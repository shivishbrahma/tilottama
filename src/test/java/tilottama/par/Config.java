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

	public String getKey() {
		return key;
	}

	public void setKey(String key) {
		this.key = key;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public ArrayList<Args> getArgs() {
		return args;
	}

	public void setArgs(ArrayList<Args> args) {
		this.args = args;
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
