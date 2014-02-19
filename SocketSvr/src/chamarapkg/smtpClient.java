package chamarapkg;

import java.io.*;
import java.net.*;
import java.util.Scanner;

public class smtpClient {
	public static void main(String[] args) {
		// declaration section:
		// smtpClient: our client socket
		// os: output stream
		// is: input stream
		Socket smtpSocket = null;
		DataOutputStream os = null;
		DataInputStream is = null;
		// Initialization section:
		// Try to open a socket on port 25
		// Try to open input and output streams
		try {
			smtpSocket = new Socket("localhost", 9999);
			os = new DataOutputStream(smtpSocket.getOutputStream());
			is = new DataInputStream(smtpSocket.getInputStream());
			
		} catch (UnknownHostException e) {
			System.err.println("Don't know about host: hostname");
		} catch (IOException e) {
			System.err
					.println("Couldn't get I/O for the connection to: hostname");
		}

		if (smtpSocket != null && os != null && is != null) {
			try {
				ResultsPrinter jj = new ResultsPrinter(is);
				Thread printerThread = new Thread(jj);
				printerThread.start();

				InputTaker kk = new InputTaker(os);
				Thread inputter = new Thread(kk);
				inputter.start();
				System.out.println("before while");
				while(!kk.isQuit()){
					try {
Thread.sleep(50);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				//	System.out.println("loop" + kk.isQuit());
				}
				System.out.println("main past while");
				jj.setQuit(true);
				

				os.close();
				is.close();
				smtpSocket.close();
				System.out.println("ending thread main");
			} catch (UnknownHostException e) {
				System.err.println("Trying to connect to unknown host: " + e);
			} catch (IOException e) {
				System.err.println("IOException:  " + e);
			}
		}
	}
}