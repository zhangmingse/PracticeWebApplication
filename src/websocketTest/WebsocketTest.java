package websocketTest;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.tomcat.util.codec.binary.Base64;


@ServerEndpoint("/websocket")
public class WebsocketTest {
	
	static  String path = new String("C:\\Users\\think\\Pictures\\iie logo.png");
	static String encodedImageAsStr = imageToBase64(path);
	static private String imageToBase64(String filepath) {

		try {
			
			InputStream imageFileInputStream = new FileInputStream(path);
			byte[] imageData = null;
			
			imageData = new byte[imageFileInputStream.available()];
			imageFileInputStream.read(imageData);
			imageFileInputStream.close();
			
			return new String(Base64.encodeBase64(imageData));
			
			
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("should not be here");
		return null;
	}
	
	@OnMessage
	public void onMessage(String message,Session session) {
		System.out.println(message);
		System.out.println(System.getProperty("user.dir"));
		try {
			//session.getBasicRemote().sendText("server has recived message : " + message);
			session.getBasicRemote().sendText(encodedImageAsStr);
			
			
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
	
	String base64 ="";

}
