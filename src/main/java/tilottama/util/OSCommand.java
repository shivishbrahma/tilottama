package tilottama.util;

import java.io.IOException;
import java.util.Scanner;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class OSCommand {
	public static void today() throws IOException {
		Process process = Runtime.getRuntime().exec("calendar");
		// deal with OutputStream to send inputs
//		process.getOutputStream();

		// deal with InputStream to get ordinary outputs
		Scanner scanner = new Scanner(process.getInputStream());
		scanner.useDelimiter("\r\n");

		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}

		scanner.close();

		// deal with ErrorStream to get error outputs
		process.getErrorStream();
	}
}
