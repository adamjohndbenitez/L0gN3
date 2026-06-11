from typing import TypedDict, Optional

class ProcessAudioMessage(TypedDict):
    type: str
    requestId: str
    audioBase64: str

class AudioResultMessage(TypedDict):
    type: str
    requestId: str
    transcript: str
    assistantText: str
    audioBase64: str

class ErrorMessage(TypedDict, total=False):
    type: str
    requestId: Optional[str]
    message: str
