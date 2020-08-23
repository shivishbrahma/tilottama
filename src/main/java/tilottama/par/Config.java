package tilottama.par;

import java.util.ArrayList;

/**
 *
 * @author Purbayan Chowdhury
 *         (<a href="https://shivishbrahma.github.io/">shivishbrahma.github.io</a>)
 */
public class Config {
	String key, url;
	ArrayList<Args> args;

	public Config() {
		this.key = "";
		this.args = new ArrayList<Args>();
		this.url = "";
	}

	public Config(String key, ArrayList<Args> args, String url) {
		this.key = key;
		this.args = args;
		this.url = url;
	}

	public void details() {
		System.out.println("Configuration :");
		if (!this.key.equals(""))
			System.out.println("API Key : \t" + this.key);
		if (this.args.size() > 0) {
			for (Args a : args)
				a.details();
		}
		if (!this.url.equals(""))
			System.out.println("Url : \t" + this.url);
	}

}
