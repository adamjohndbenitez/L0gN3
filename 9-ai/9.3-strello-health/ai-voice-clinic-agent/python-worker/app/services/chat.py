from app.openai_client import client
from app.prompts import SYSTEM_PROMPT

def generate_response(user_text: str) -> str:
    response = client.responses.create(
        model="gpt-5.2",
        instructions=SYSTEM_PROMPT,
        input=user_text,
    )
    return response.output_text or "Sorry, I didn't catch that."
