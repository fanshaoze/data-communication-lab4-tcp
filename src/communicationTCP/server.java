package communicationTCP;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.SocketException;
public class server {
	public static int Port = 10010;
	private ServerSocket aSocket;

	public void Server() {
		getPort(Port);
		System.out.println("the port is " + Port);
		Socket s_package = new Socket();
		try {
			while (true) {
				s_package = aSocket.accept();
				//System.out.println("Server Message:Bind port success,the port is " + Port + ".");
				System.out.println("ip:" + s_package.getInetAddress().getHostAddress() + " "+ " port:" + s_package.getPort());

				DataInputStream dis = new DataInputStream(s_package.getInputStream());				
				String message = dis.readLine();		
				System.out.println(":" + message + ".");
				String backmess = message.toUpperCase();
				
				
				System.out.println("send to client :" + backmess + ".");
				DataOutputStream dos = new DataOutputStream(s_package.getOutputStream());
				dos.writeUTF(backmess);
				System.out.println("send back!");
				
				
				dos.flush();
				dis.close();
				dos.close();
				//s_package.close();
				
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();			
		}
	}

	public void getPort(int port) {
		while (true) {
			try {
				aSocket = new ServerSocket(Port);
				break;
			} catch (IOException e) {
				Port++;
			}
		}
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new server().Server();
	}

}
