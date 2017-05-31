package bio;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class TimeServer {

	public static void main(String args[]) throws IOException{
		int port = 8080;
		ServerSocket server = null;
		try {
			server = new ServerSocket(port);
			System.out.println("timeserver start at port"+port);
			Socket socket = null;
			for(;;){
				socket = server.accept();
				new Thread(new TimeServerHandler(socket)).start();
			}
		} finally {
			if(server != null){
				System.out.println("time server close");
				server.close();
				server = null;
			}
		}
	}
}
