package luiz787.pocws.core;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Component;
import org.springframework.web.socket.TextMessage;
import org.springframework.web.socket.WebSocketSession;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

@Component
public class WsFacade {
    List<WebSocketSession> sessions = new CopyOnWriteArrayList<>();

    public void sendMessage(Object message) throws IOException {
        ObjectMapper mapper = new ObjectMapper();
        System.out.println(sessions.size());
        for(WebSocketSession webSocketSession : sessions) {
            System.out.println("Sending");
            webSocketSession.sendMessage(new TextMessage(mapper.writeValueAsString(message)));
        }
    }
}
