import WebSocket from "ws";
import { config } from "../config.js";
import type { PythonInbound, PythonOutbound } from "../types/messages.js";

type PendingHandler = (msg: PythonInbound) => void;

class PythonBridge {
  private ws: WebSocket | null = null;
  private pending = new Map<string, PendingHandler>();

  connect() {
    this.ws = new WebSocket(config.pythonWsUrl);

    this.ws.on("open", () => {
      console.log("Connected to Python worker");
    });

    this.ws.on("message", (raw) => {
      const msg = JSON.parse(raw.toString()) as PythonInbound;
      if ("requestId" in msg && msg.requestId) {
        const handler = this.pending.get(msg.requestId);
        if (handler) {
          handler(msg);
          this.pending.delete(msg.requestId);
        }
      }
    });

    this.ws.on("close", () => {
      console.log("Python worker disconnected, retrying...");
      setTimeout(() => this.connect(), 1000);
    });

    this.ws.on("error", (err) => {
      console.error("Python bridge error:", err);
    });
  }

  sendAndWait(payload: PythonOutbound): Promise<PythonInbound> {
    return new Promise((resolve, reject) => {
      if (!this.ws || this.ws.readyState !== WebSocket.OPEN) {
        reject(new Error("Python worker not connected"));
        return;
      }

      this.pending.set(payload.requestId, resolve);
      this.ws.send(JSON.stringify(payload));

      setTimeout(() => {
        if (this.pending.has(payload.requestId)) {
          this.pending.delete(payload.requestId);
          reject(new Error("Timed out waiting for Python worker"));
        }
      }, 30000);
    });
  }
}

export const pythonBridge = new PythonBridge();
