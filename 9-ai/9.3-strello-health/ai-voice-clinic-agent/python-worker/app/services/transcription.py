import base64
import io
from app.openai_client import client

def transcribe_webm_base64(audio_base64: str) -> str:
    audio_bytes = base64.b64decode(audio_base64)
    audio_file = io.BytesIO(audio_bytes)
    audio_file.name = "input.webm"

    transcription = client.audio.transcriptions.create(
        model="gpt-4o-transcribe",
        file=audio_file,
    )
    return transcription.text
