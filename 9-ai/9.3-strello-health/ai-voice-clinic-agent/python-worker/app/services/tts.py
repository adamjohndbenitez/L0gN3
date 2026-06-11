import base64
from app.openai_client import client

def synthesize_speech_base64(text: str) -> str:
    with client.audio.speech.with_streaming_response.create(
        model="tts-1",
        voice="alloy",
        input=text,
    ) as response:
        audio_bytes = response.read()

    return base64.b64encode(audio_bytes).decode("utf-8")
