package chamarapkg;

import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class ResultsPrinter implements Runnable {

	private DataInputStream is;
	private boolean quit;

	public boolean isQuit() {
		return quit;
	}

	public void setQuit(boolean quit) {
		this.quit = quit;
	}

	public ResultsPrinter(DataInputStream is) {
		this.is = is;
		// TODO Auto-generated constructor stub
	}

	public void run() {
		String responseLine = null;
		try {
			responseLine = is.readLine();
			while (responseLine != null && !quit) {
				System.out.println("");
				System.out.println("Server says: " + responseLine);
				if ("quit".equalsIgnoreCase(responseLine)) {
					System.out.println("breaking Resultprinter");
					break;

				}
				responseLine = is.readLine();

			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println("ending thread print");
	}
}
