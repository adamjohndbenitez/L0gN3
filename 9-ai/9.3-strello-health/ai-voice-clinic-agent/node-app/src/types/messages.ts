export type BrowserInbound =
  | { type: "audio_input"; audioBase64: string }
  | { type: "ping" };

export type PythonOutbound = {
  type: "process_audio";
  requestId: string;
  audioBase64: string;
};

export type PythonInbound =
  | {
      type: "audio_result";
      requestId: string;
      transcript: string;
      assistantText: string;
      audioBase64: string;
    }
  | {
      type: "error";
      requestId?: string;
      message: string;
    };
