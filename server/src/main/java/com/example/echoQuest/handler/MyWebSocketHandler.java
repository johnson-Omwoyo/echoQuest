package com.example.echoQuest.handler;

import java.util.concurrent.ConcurrentHashMap;
import org.springframework.web.socket.CloseStatus;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;
import org.springframework.web.socket.handler.TextWebSocketHandler;

public class MyWebSocketHandler extends TextWebSocketHandler {
  private static ConcurrentHashMap<String, WebSocketSession> clients = new ConcurrentHashMap<>();

  @Override
  public void afterConnectionEstablished(WebSocketSession session) throws Exception {
    String email = getEmailFromSession(session);
    clients.put(email, session);
    // session.sendMessage(new TextMessage("Connection Established with email: " + email));
  }

  @Override
  public void afterConnectionClosed(WebSocketSession session, CloseStatus status) throws Exception {
    String email = getEmailFromSession(session);
    clients.remove(email);
  }

  public static void sendMessageToClient(String email, String message) throws Exception {
    WebSocketSession session = clients.get(email);
    if (session != null && session.isOpen()) {
      session.sendMessage(new TextMessage(message));
    }
  }

  private String getEmailFromSession(WebSocketSession session) {
    String query = session.getUri().getQuery();
    String[] params = query.split("&");
    for (String param : params) {
      if (param.startsWith("email=")) {
        return param.split("=")[1];
      }
    }
    return null;
  }
}

// ...........
