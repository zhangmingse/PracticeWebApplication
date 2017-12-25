package websocketTest;

import java.io.IOException;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

@ServerEndpoint("/websocket")
public class WebsocketTest {
	
	@OnMessage
	public void onMessage(String message,Session session) {
		System.out.println(message);
		try {
			session.getBasicRemote().sendText("server has recived message : " + message);
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	@OnOpen
	public void onOpen() {
		System.out.println("onopen");
	}
	
	@OnClose
	public void onClose() {
		System.out.println("onclose");
	}
	

}
