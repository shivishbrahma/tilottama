package tilottama.par;

import java.io.IOException;
import java.util.StringTokenizer;
import tilottama.App;
import tilottama.game.MainGame;
import tilottama.gui.Gui;
import tilottama.util.CurrencyConvertor;
import tilottama.util.WeatherApp;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class ServiceHandler {

	/**
	 * @param app
	 * @param cmd
	 */
	public static void findAndRun(App app, String cmd) {
		MainGame mg = new MainGame();
		StringTokenizer token = new StringTokenizer(cmd);
		String args, select;
		select = token.nextToken();
		// Weather App
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

		// System Info Commands
		if (select.equalsIgnoreCase("cpu")) {
			tilottama.util.OSSystem.details();
			return;
		}
		if (select.equalsIgnoreCase("os")) {
			tilottama.util.OSSystem.osInfo();
			return;
		}
		if (select.equalsIgnoreCase("user")) {
			tilottama.util.OSSystem.userInfo();
			return;
		}
		if (select.equalsIgnoreCase("java")) {
			tilottama.util.OSSystem.javaDetails();
			return;
		}
		if (select.equalsIgnoreCase("sysinfo")) {
			try {
				tilottama.util.OSSystem.systemInfo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		// System Commands
		if (select.equalsIgnoreCase("today")) {
			try {
				tilottama.util.OSCommand.today();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		// Currency Converter
		if (select.equalsIgnoreCase("currency")) {
			CurrencyConvertor c = new CurrencyConvertor(app, "Currency");
			args = cmd.replace(select, "").trim();
			c.convertCurrency(args);
			return;
		}
		// Temperature Convertor
		if (select.equalsIgnoreCase("temperature")) {
			args = cmd.replaceAll(select, "").trim();
			tilottama.par.Temperature.temperatureConv(args);
			return;
		}

		// Wiki
		if (select.equalsIgnoreCase("wiki")) {
			args = cmd.replaceAll(select, "").trim();
			Wiki wk = new Wiki(args);
			wk.details();
			return;
		}

		// Roll dice
		if (select.equalsIgnoreCase("roll")) {
			mg.rollDice();
			return;
		}

		// Flip coin
		if (select.equalsIgnoreCase("coin")) {
			mg.flipCoin();
			return;
		}

		// Pi Digits
		if (select.equalsIgnoreCase("pi")) {
			args = cmd.replaceAll(select, "").trim();
			if (args.equalsIgnoreCase(""))
				mg.pi(64*64-3);
			else
				mg.pi(Integer.parseInt(args));
			return;
		}
		
		// Gui
		if(select.equalsIgnoreCase("gui")) {
			Gui gui = new Gui(app);

			gui.setVisible(true);
			return;
		}
	}

}
