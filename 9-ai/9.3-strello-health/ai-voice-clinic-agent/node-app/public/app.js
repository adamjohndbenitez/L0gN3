const startBtn = document.getElementById("startBtn");
const stopBtn = document.getElementById("stopBtn");
const transcriptEl = document.getElementById("transcript");
const assistantEl = document.getElementById("assistant");
const player = document.getElementById("player");

let ws;
let recorder;
let chunks = [];

startBtn.onclick = async () => {
  ws = new WebSocket(`ws://${location.host}/ws`);

  ws.onmessage = (event) => {
    const msg = JSON.parse(event.data);

    if (msg.type === "audio_result") {
      transcriptEl.textContent = msg.transcript;
      assistantEl.textContent = msg.assistantText;
      player.src = `data:audio/mpeg;base64,${msg.audioBase64}`;
      player.play().catch(() => {});
    }

    if (msg.type === "error") {
      assistantEl.textContent = msg.message;
    }
  };

  const stream = await navigator.mediaDevices.getUserMedia({ audio: true });
  recorder = new MediaRecorder(stream, { mimeType: "audio/webm" });
  chunks = [];

  recorder.ondataavailable = (e) => {
    if (e.data.size > 0) chunks.push(e.data);
  };

  recorder.onstop = async () => {
    const blob = new Blob(chunks, { type: "audio/webm" });
    const buf = await blob.arrayBuffer();
    const bytes = new Uint8Array(buf);
    let binary = "";
    for (const b of bytes) binary += String.fromCharCode(b);
    const audioBase64 = btoa(binary);

    ws.send(JSON.stringify({ type: "audio_input", audioBase64 }));
  };

  recorder.start();
  startBtn.disabled = true;
  stopBtn.disabled = false;
};

stopBtn.onclick = () => {
  recorder.stop();
  startBtn.disabled = false;
  stopBtn.disabled = true;
};
