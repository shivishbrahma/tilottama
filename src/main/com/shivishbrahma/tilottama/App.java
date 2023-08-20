package com.shivishbrahma.tilottama;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Logger;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

// import org.apache.logging.log4j.LogManager;
// import org.apache.logging.log4j.Logger;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.shivishbrahma.tilottama.gui.About;
import com.shivishbrahma.tilottama.gui.Calculator;
import com.shivishbrahma.tilottama.gui.Converter;
import com.shivishbrahma.tilottama.gui.Notepad;
import com.shivishbrahma.tilottama.handlers.ServiceHandler;
import com.shivishbrahma.tilottama.models.Service;

/**
 * Tilottama main class and its starting point
 *
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 */
public class App {
	private static final Logger logger = Logger.getLogger(App.class.getName());
	private ArrayList<Service> services;
	private String name, version;
	private ArrayList<String> authors = new ArrayList<>();
	private Map<String, JFrame> frames = new HashMap<>();
	private ImageIcon icon;

	App() {
		Locale locale = new Locale("en", "IN");
		Locale.setDefault(locale);

		this.setName("Tillotama(তিলোতমা)");
		this.setVersion("1.0.1");
		this.addAuthor("Purbayan Chowdhury");
		this.setIcon(new ImageIcon(this.getClass().getResource("/images/icon.png")));
		this.initGuiServices();
		this.readServices();
	}

	/**
	 * Initialise GUI screens
	 */
	private void initGuiServices() {
		this.frames.put("about", new About(this));
		this.frames.put("calculator", new Calculator(this));
		this.frames.put("converter", new Converter(this));
		this.frames.put("notepad", new Notepad(this));
	}

	/**
	 * Read services from config.json
	 */
	private void readServices() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileReader fr;
		try {
			String fileName = "data/config.json";

			URL url = this.getClass().getClassLoader().getResource(fileName);

			if (url == null) {
				throw new IllegalArgumentException(fileName + " is not found!");
			}

			File file = new File(url.getFile());

			fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);

			logger.info("Read successfully!");

			Type arrayListType = new TypeToken<ArrayList<Service>>() {
			}.getType();
			this.services = gson.fromJson(br, arrayListType);
			// for (Service i : this.services)
			// logger.info(i.toString());
		} catch (IOException e) {
			logger.severe(e.getLocalizedMessage());
		}
	}

	/**
	 * Taking command as input
	 *
	 * @return Command
	 */
	private String input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the command");
			String cmd = br.readLine();
			return cmd;
		} catch (IOException e) {
			logger.severe(e.getLocalizedMessage());
			return "";
		}
	}

	/**
	 * Parse string for execution
	 *
	 * @param cmd String - Command
	 */
	private void callService(String cmd) {
		ServiceHandler.findAndRun(this, cmd);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getVersion() {
		return version;
	}

	public void setVersion(String version) {
		this.version = version;
	}

	public Map<String, JFrame> getFrames() {
		return frames;
	}

	public void setFrames(Map<String, JFrame> frames) {
		this.frames = frames;
	}

	public ImageIcon getIcon() {
		return icon;
	}

	public void setIcon(ImageIcon icon) {
		this.icon = icon;
	}

	public ArrayList<String> getAuthors() {
		return authors;
	}

	public void setAuthors(ArrayList<String> authors) {
		this.authors = authors;
	}
	
	public void addAuthor(String author) {
		this.authors.add(author);
	}

	public ArrayList<Service> getServices() {
		return services;
	}

	public void setServices(ArrayList<Service> services) {
		this.services = services;
	}

	/**
	 *
	 * @param args String - arguments array
	 */
	public static void main(String[] args) {
		App app = new App();
		String cmd = app.input();
		app.callService(cmd);
	}
}
