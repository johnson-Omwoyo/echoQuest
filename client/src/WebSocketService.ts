// src/WebSocketService.ts
import { Client, IFrame, Message } from "@stomp/stompjs";
import SockJS from "sockjs-client";

class WebSocketService {
  public stompClient: Client | null = null;
  private socket: WebSocket | null = null;

  constructor() {}

  connect(): void {
    this.socket = new SockJS("/video-chat"); // Assuming your backend is running at the same address

    // Initialize the stompClient
    this.stompClient = new Client({
      webSocketFactory: () => this.socket as WebSocket,
      onConnect: (frame: IFrame) => {
        console.log("Connected: " + frame);

        // Subscribe to a topic after successful connection
        this.stompClient?.subscribe("/topic/call", (message: Message) => {
          console.log(message.body);
        });
      },
      onStompError: (frame: IFrame) => {
        console.error("Error: " + frame.headers["message"]);
      },
    });

    // Activate the connection (this replaces `connect()` in newer versions)
    this.stompClient.activate();
  }

  sendMessage(destination: string, message: string): void {
    if (this.stompClient?.connected) {
      (this.stompClient as any).send(destination, {}, message); // Cast to any before calling send
    } else {
      console.error("Stomp client is not connected");
    }
  }

  disconnect(): void {
    if (this.stompClient?.connected) {
      this.stompClient.deactivate(); // Deactivate instead of disconnect in v6.x
    }
  }
}

export default new WebSocketService();
