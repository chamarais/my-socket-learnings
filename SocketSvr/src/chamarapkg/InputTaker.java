package chamarapkg;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Scanner;


public class InputTaker implements Runnable {

	private DataOutputStream out;
	private boolean quit;
	
	
	public boolean isQuit() {
		return quit;
	}


	public void setQuit(boolean quit) {
		this.quit = quit;
	}


	public InputTaker(DataOutputStream out) {
		this.out = out;
		this.quit = false;
		// TODO Auto-generated constructor stub
	}
	
	
    public void run() {

		try {
			boolean flag = true;
			while (flag) {
				System.out.print("Please Input :");
				Scanner sc = new Scanner(System.in);
				String inputcode = sc.nextLine();
				//System.out.println("input is: " + inputcode);
				if("quit".equalsIgnoreCase(inputcode)) {this.setQuit(true);
				out.writeBytes(inputcode + "\n");
				setQuit(true);
				break;}else{
					out.writeBytes(inputcode + "\n");
				}

			}
		

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ending thread input");

    }
}
