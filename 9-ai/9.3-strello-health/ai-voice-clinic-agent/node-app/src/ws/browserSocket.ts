import { WebSocketServer, WebSocket } from "ws";
import crypto from "node:crypto";
import { pythonBridge } from "./pythonBridge.js";
import type { BrowserInbound } from "../types/messages.js";

export function attachBrowserSocket(wss: WebSocketServer) {
  wss.on("connection", (socket: WebSocket) => {
    socket.on("message", async (raw) => {
      try {
        const msg = JSON.parse(raw.toString()) as BrowserInbound;

        if (msg.type === "ping") {
          socket.send(JSON.stringify({ type: "pong" }));
          return;
        }

        if (msg.type === "audio_input") {
          const requestId = crypto.randomUUID();

          const result = await pythonBridge.sendAndWait({
            type: "process_audio",
            requestId,
            audioBase64: msg.audioBase64,
          });

          socket.send(JSON.stringify(result));
        }
      } catch (err) {
        console.error(err);
        socket.send(
          JSON.stringify({
            type: "error",
            message: "Failed to process request",
          })
        );
      }
    });
  });
}
