package websocketTest;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.nio.ByteBuffer;

import javax.websocket.OnClose;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.ServerEndpoint;

import org.apache.tomcat.util.codec.binary.Base64;

@ServerEndpoint("/websocket")
public class WebsocketTest {

	static String path = new String("C:\\Users\\think\\Pictures\\testpicture\\");
	int current_image_index = 1;
	static int total_image_number = 1;
	static String[] base64EncodedImage = new String[total_image_number];
	static byte[][] imageData = new byte[total_image_number][];
	static {
		imageToBase64(path);
	}

	static private void imageToBase64(String filepath) {

		try {

			InputStream imageFileInputStream = null;

			for(int i = 0;i<total_image_number;i++) {
				imageFileInputStream = new FileInputStream(path + (i+1) + ".jpg");
				imageData[i] = new byte[imageFileInputStream.available()];
				imageFileInputStream.read(imageData[i]);
				imageFileInputStream.close();
				base64EncodedImage[i] = new String(Base64.encodeBase64(imageData[i]));
			}
			System.out.println("image loaded and encoded");
			return ;

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		System.out.println("should not be here");
	}

	@OnMessage
	public void onMessage(String message, Session session) {
		
		current_image_index = (current_image_index+1)%total_image_number;
		if (message.trim().equals("base64")) {
			try {
				// session.getBasicRemote().sendText("server has recived message : " + message);
				
				session.getBasicRemote().sendText(base64EncodedImage[current_image_index]);

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else if(message.trim().equals("binary")) {
			try {
				// session.getBasicRemote().sendText("server has recived message : " + message);
				
				ByteBuffer buffer = ByteBuffer.wrap(imageData[current_image_index]);
				session.getBasicRemote().sendBinary(buffer);
				

			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else {
			System.out.println("unsupported message : " + message);
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

	String base64 = "";

}
