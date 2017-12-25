package communicationTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;
public class client {

	private String s_address = "127.0.0.1";
	//private int Port = server.Port;
	private int Port = 10010;
	public void sendmessages(){
			try {
				Socket clientSocket = new Socket(s_address,Port);
				//clientSocket.setSoTimeout(3000);
				String message = "hello i am client"+"\0";
				clientSocket.getOutputStream().write(message.getBytes());
				DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());
				
				System.out.println(message);
				//dos.flush();
				//System.out.println(Port);
				System.out.println("Send messageAAAAAAAAAAAAAAAa");
				
				DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
				//System.out.println(Port+"1");
				String sendback = dis.readUTF();
				System.out.println("get from server:" + sendback);
				
				dos.close();
				dis.close();
				clientSocket.close();
				
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new client().sendmessages();
	}
}

