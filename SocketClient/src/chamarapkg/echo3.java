package chamarapkg;

import java.io.*;
import java.net.*;

public class echo3 {
	public static void main(String args[]) {
		ServerSocket echoServer = null;
		String line;
		DataInputStream is;
		PrintStream os;
		Socket clientSocket = null;
		try {
			echoServer = new ServerSocket(9999);
		} catch (IOException e) {
			System.out.println(e);
		}
		try {
			System.out.println("no client yet");
			clientSocket = echoServer.accept();
			is = new DataInputStream(clientSocket.getInputStream());
			os = new PrintStream(clientSocket.getOutputStream());
			System.out.println("client came");
			while (true) {
				line = is.readLine();
				if (line != null) {
					System.out.println(line);
				}
				System.out.print(line);
				if ("quit".equalsIgnoreCase(line)) {
					os.println(line);
					break;
				} else {
					os.println(line);
				}

				

			}
		} catch (IOException e) {
			System.out.println(e);
		}
	}
}
