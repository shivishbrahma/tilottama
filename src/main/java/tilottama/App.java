package tilottama;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.StringTokenizer;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import tilottama.par.Config;
import tilottama.par.Service;
import tilottama.util.WeatherApp;

/**
 * Tilottama main class and its starting point
 * 
 * @author Purbayan Chowdhury (<a href=
 *         "https://shivishbrahma.github.io/">shivishbrahma.github.io</a>)
 */
public class App {
	private ArrayList<Service> services;

	public ArrayList<Service> getServices() {
		return services;
	}

	App() {
		this.readServices();
	}

	public ArrayList<Service> dummyServices() {
		ArrayList<Service> dummyServices = new ArrayList<Service>();
		Service newService = new Service("Weather", "weather", new Config("8f7b2ef26a8f5e88eb25ae02606284c2", null,
				"http://api.ipstack.com/check?access_key=%s&output=json&legacy=1"));
		dummyServices.add(newService);
		return dummyServices;
	}

	public void writeServices() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileWriter fw;
		try {
			fw = new FileWriter(new File("config.json"));
			fw.write(gson.toJson(dummyServices()));
			fw.close();
			System.out.println("Written successfully!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * 
	 */
	public void readServices() {
		GsonBuilder builder = new GsonBuilder();
		Gson gson = builder.create();
		FileReader fr;
		try {
			fr = new FileReader(new File("config.json"));
			BufferedReader br = new BufferedReader(fr);

			System.out.println("Read successfully!");
			Type arrayListType = new TypeToken<ArrayList<Service>>() {
			}.getType();
			this.services = gson.fromJson(br, arrayListType);
//            for(Service i : this.services)
//                    i.details();

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * @return Command taken as input
	 */
	public String input() {
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			System.out.println("Enter the command");
			String cmd = br.readLine();
			return cmd;
		} catch (IOException e) {
			e.printStackTrace();
			return "";
		}
	}

	/**
	 * @param cmd - Command string to be parsed for execution
	 */
	public void callService(String cmd) {
		StringTokenizer token = new StringTokenizer(cmd);
		String args, select;
		select = token.nextToken();
		if (select.equalsIgnoreCase("Weather")) {
			WeatherApp w = new WeatherApp(this, "Weather");
			args = cmd.replace(select, "").trim();
			w.findWeather(args);
			return;
		} else if (select.equalsIgnoreCase("Forecast")) {
			WeatherApp w = new WeatherApp(this, "Forecast");
			args = cmd.replace(select, "").trim();
			w.findForecast(args);
			return;
		}
	}

	public static void main(String[] args) {
		App app = new App();
//		app.writeServices();
		String cmd = app.input();
		app.callService(cmd);
	}
}
