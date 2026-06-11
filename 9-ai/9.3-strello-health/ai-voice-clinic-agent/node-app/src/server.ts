import express from "express";
import cors from "cors";
import path from "node:path";
import { fileURLToPath } from "node:url";
import { createServer } from "node:http";
import { WebSocketServer } from "ws";
import { config } from "./config.js";
import { attachBrowserSocket } from "./ws/browserSocket.js";
import { pythonBridge } from "./ws/pythonBridge.js";
import { healthRouter } from "./routes/health.js";

const __filename = fileURLToPath(import.meta.url);
const __dirname = path.dirname(__filename);

const app = express();
app.use(cors());
app.use(express.json({ limit: "20mb" }));
app.use(express.static(path.join(__dirname, "../public")));
app.use("/health", healthRouter);

const server = createServer(app);
const wss = new WebSocketServer({ server, path: "/ws" });

pythonBridge.connect();
attachBrowserSocket(wss);

server.listen(config.nodePort, () => {
  console.log(`Node app running on http://localhost:${config.nodePort}`);
});
