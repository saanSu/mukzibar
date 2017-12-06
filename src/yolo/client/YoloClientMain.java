package yolo.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class YoloClientMain {
	public static void main(String[] args) throws UnknownHostException, IOException {
		
		Socket s =new Socket("192.168.104.100", 45678); 
		new ObjectOutputStream(s.getOutputStream());
		new ObjectInputStream(s.getInputStream());
	}
}
