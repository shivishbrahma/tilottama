package com.shivishbrahma.tilottama.main.par;

import java.io.IOException;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import com.shivishbrahma.tilottama.main.App;
import com.shivishbrahma.tilottama.main.game.MainGame;
import com.shivishbrahma.tilottama.main.gui.Gui;
import com.shivishbrahma.tilottama.main.util.CurrencyConvertor;
import com.shivishbrahma.tilottama.main.util.WeatherApp;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class ServiceHandler {
    Logger rootLogger = Logger.getLogger(App.class.getName());

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
            com.shivishbrahma.tilottama.main.util.OSSystem.details();
            return;
        }
        if (select.equalsIgnoreCase("os")) {
            com.shivishbrahma.tilottama.main.util.OSSystem.osInfo();
            return;
        }
        // IP
        if (select.equalsIgnoreCase("ip")) {
            com.shivishbrahma.tilottama.main.util.OSSystem.ipInfo();
            return;
        }
        if (select.equalsIgnoreCase("user")) {
            com.shivishbrahma.tilottama.main.util.OSSystem.userInfo();
            return;
        }
        if (select.equalsIgnoreCase("java")) {
            com.shivishbrahma.tilottama.main.util.OSSystem.javaDetails();
            return;
        }
        if (select.equalsIgnoreCase("sysinfo")) {
            try {
                com.shivishbrahma.tilottama.main.util.OSSystem.systemInfo();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
            return;
        }

        // System Commands
        if (select.equalsIgnoreCase("today")) {
            try {
                com.shivishbrahma.tilottama.main.util.OSCommand.today();
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
            com.shivishbrahma.tilottama.main.par.Temperature.temperatureConv(args);
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

    public String parseArgs() {
        return "";
    }

}
