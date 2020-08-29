/**
 * 
 */
package tilottama.par;

/**
 * @author Purbayan Chowdhury
 *         (<a href="shivishbrahma.github.io">shivishbrahma.github.io</a>)
 *
 */
public class StringHandler {
	public static String leftAligned(String data, int size) {
		String res = data, filler=" ";
		if (data.length() < size) {
			String filled = "";
			for (int i = 0; i < size-data.length(); i++) {
				filled += filler;
			}
			res = res.concat(filled);
		}
		return res;
	}
	
	public static String leftAligned(String data, int size, String filler) {
		String res = data;
		if (data.length() < size) {
			String filled = "";
			for (int i = 0; i < size-data.length(); i++) {
				filled += filler;
			}
			res = res.concat(filled);
		}
		return res;
	}
	
	public static String rightAligned(String data, int size) {
		String res = data, filler=" ";
		if (data.length() < size) {
			String filled = "";
			for (int i = 0; i < size-data.length(); i++) {
				filled += filler;
			}
			res = filled.concat(res);
		}
		return res;
	}
	public static String rightAligned(String data, int size, String filler) {
		String res = data;
		if (data.length() < size) {
			String filled = "";
			for (int i = 0; i < size-data.length(); i++) {
				filled += filler;
			}
			res = filled.concat(res);
		}
		return res;
	}
	
	public static String centerAligned(String data, int size) {
		String res = data, filler=" ";
		if (data.length() < size) {
			String filled = "";
			for (int i = 0; i < (size-size/2)-(data.length()-data.length()/2); i++) {
				filled += filler;
			}
			res = res.concat(filled);
			filled="";
			for (int i = 0; i < size/2-data.length()/2; i++) {
				filled += filler;
			}
			res = filled.concat(res);
		}
		return res;
	}
	
	public static String centerAligned(String data, int size, String filler) {
		String res = data;
		if (data.length() < size) {
			String filled = "";
			for (int i = 0; i < (size-size/2)-(data.length()-data.length()/2); i++) {
				filled += filler;
			}
			res = res.concat(filled);
			filled="";
			for (int i = 0; i < size/2-data.length()/2; i++) {
				filled += filler;
			}
			res = filled.concat(res);
		}
		return res;
	}
}
