package tilottama.par;

import java.util.StringTokenizer;

import tilottama.App;
import tilottama.util.CurrencyConvertor;
import tilottama.util.WeatherApp;

public class ServiceHandler {
	
	public static void findAndRun(App app,String cmd) {
		StringTokenizer token = new StringTokenizer(cmd);
		String args, select;
		select = token.nextToken();
		if (select.equalsIgnoreCase("weather")) {
			WeatherApp w = new WeatherApp(app, "Weather");
			args = cmd.replace(select, "").trim();
			w.findWeather(args);
			return;
		}
		if (select.equalsIgnoreCase("forecast")) {
			WeatherApp w = new WeatherApp(app, "Forecast");
			args = cmd.replace(select, "").trim();
			w.findForecast(args);
			return;
		} 
		if (select.equalsIgnoreCase("cpu")) {
			tilottama.util.OSSystem.details();
			return;
		}
		if(select.equalsIgnoreCase("currency")) {
			CurrencyConvertor c = new CurrencyConvertor(app, "Currency");
			args = cmd.replace(select, "").trim();
			c.convertCurrency(args);
			return;
		}
	}

}
