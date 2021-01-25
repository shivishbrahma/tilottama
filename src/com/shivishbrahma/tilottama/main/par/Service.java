package com.shivishbrahma.tilottama.main.par;

/**
 *
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Service {
	private String name, cmd;
	private Config config;

	public Service() {
		this.name = "";
		this.cmd = "";
		this.config = null;
	}

	public Service(String name, String cmd, Config config) {
		this.name = name;
		this.cmd = cmd;
		this.config = config;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCmd() {
		return cmd;
	}

	public void setCmd(String cmd) {
		this.cmd = cmd;
	}

	public Config getConfig() {
		return config;
	}

	public void setConfig(Config config) {
		this.config = config;
	}

	public void details() {
		System.out.println("Service " + this.getName() + " :");
		System.out.println("Command :\t" + this.getCmd());
		this.getConfig().details();
	}
}
