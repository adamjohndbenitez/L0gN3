import "dotenv/config";

export const config = {
  nodePort: Number(process.env.NODE_PORT || 3000),
  pythonWsUrl: process.env.PYTHON_WS_URL || "ws://localhost:8765",
};
