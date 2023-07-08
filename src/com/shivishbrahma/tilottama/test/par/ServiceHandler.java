package com.shivishbrahma.tilottama.test.par;

import java.io.IOException;
import java.util.StringTokenizer;
import com.shivishbrahma.tilottama.main.App;
import com.shivishbrahma.tilottama.main.game.MainGame;
import com.shivishbrahma.tilottama.main.gui.Gui;
import com.shivishbrahma.tilottama.main.util.CurrencyConvertor;
import com.shivishbrahma.tilottama.main.util.WeatherApp;
import com.shivishbrahma.tilottama.main.util.OSSystem;
import com.shivishbrahma.tilottama.main.util.OSCommand;
import com.shivishbrahma.tilottama.main.par.Temperature;

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
			OSSystem.details();
			return;
		}
		if (select.equalsIgnoreCase("os")) {
			OSSystem.osInfo();
			return;
		}
		// IP
		if(select.equalsIgnoreCase("ip")) {
			OSSystem.ipInfo();
			return;
		}
		if (select.equalsIgnoreCase("user")) {
			OSSystem.userInfo();
			return;
		}
		if (select.equalsIgnoreCase("java")) {
			OSSystem.javaDetails();
			return;
		}
		if (select.equalsIgnoreCase("sysinfo")) {
			try {
				OSSystem.systemInfo();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return;
		}

		// System Commands
		if (select.equalsIgnoreCase("today")) {
			try {
				OSCommand.today();
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
			Temperature.temperatureConv(args);
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
				mg.pi(64 * 64 - 3);
			else
				mg.pi(Integer.parseInt(args));
			return;
		}

		// Gui
		if (select.equalsIgnoreCase("gui")) {
			args = cmd.replaceAll(select, "").trim();
			if (args.equalsIgnoreCase("") || !app.getFrames().containsKey(args)) {
				Gui gui = new Gui(app);
				gui.setVisible(true);
			} else {
				app.getFrames().get(args).setVisible(true);
			}
			return;
		}
		
	}

}
