import json
from typing import cast
import websockets
from app.schemas import ProcessAudioMessage
from app.services.transcription import transcribe_webm_base64
from app.services.chat import generate_response
from app.services.tts import synthesize_speech_base64

HOST = "0.0.0.0"
PORT = 8765

async def handler(websocket):
    async for raw_message in websocket:
        request_id = None
        try:
            msg = cast(ProcessAudioMessage, json.loads(raw_message))
            request_id = msg.get("requestId")

            if msg.get("type") != "process_audio":
                await websocket.send(json.dumps({
                    "type": "error",
                    "requestId": request_id,
                    "message": "Unsupported message type"
                }))
                continue

            # Fully mocked response: no OpenAI calls
            #transcript = transcribe_webm_base64(msg["audioBase64"])
            transcript = "I would like to book an appointment tomorrow morning."
            #assistant_text = generate_response(transcript)
            assistant_text = "Our clinic is open from 9 AM to 5 PM. Would you like to book an appointment?"
            #audio_base64 = synthesize_speech_base64(assistant_text)
            audio_base64 = "" # skip TTS(Text-To-Speech) for now. TTS is one of the more expensive parts.


            await websocket.send(json.dumps({
                "type": "audio_result",
                "requestId": request_id,
                "transcript": transcript,
                "assistantText": assistant_text,
                "audioBase64": audio_base64
            }))

        except Exception as exc:
            await websocket.send(json.dumps({
                "type": "error",
                "requestId": request_id,
                "message": f"Worker error: {str(exc)}"
            }))

async def main():
    async with websockets.serve(handler, HOST, PORT, max_size=20_000_000):
        print(f"Python worker listening on ws://{HOST}:{PORT}")
        await asyncio.Future()

if __name__ == "__main__":
    import asyncio
    asyncio.run(main())
