# AI Voice Clinic Agent

Small MVP for a healthcare voice assistant using:

- Node.js + TypeScript
- Browser WebSocket transport
- Python AI worker
- OpenAI transcription
- OpenAI text generation
- OpenAI text-to-speech

## Flow

1. User records audio in browser
2. Browser sends audio to Node over WebSocket
3. Node forwards job to Python worker
4. Python transcribes audio
5. Python generates assistant reply
6. Python synthesizes speech
7. Node sends transcript + text + audio back to browser

## Run

### Terminal 1
npm install
npm run dev

### Terminal 2
cd python-worker
pip install -r requirements.txt
python app/main.py

## Next steps

- add appointment-booking function calls
- add conversation memory
- replace batch audio with streaming chunks
- upgrade to OpenAI Realtime API
