package com.shivishbrahma.tilottama.handlers;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;
import java.util.logging.Logger;

import com.shivishbrahma.tilottama.App;
import com.shivishbrahma.tilottama.annotations.ArgAnnotate;
import com.shivishbrahma.tilottama.annotations.CommandAnnotate;
import com.shivishbrahma.tilottama.controllers.GameController;
import com.shivishbrahma.tilottama.models.Arg;

/**
 * @author Purbayan Chowdhury<a href=
 * "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 */
public class ServiceHandler {
    static Logger rootLogger = Logger.getLogger(App.class.getName());

    /**
     * @param app App
     * @param cmd String
     */
    public static void findAndRun(App app, String cmd) {
        StringTokenizer token = new StringTokenizer(cmd);
        String args, select;
        select = token.nextToken();
        // Weather App
//        if (select.equalsIgnoreCase("weather")) {
//            WeatherApp w = new WeatherApp(app, "Weather");
//            args = cmd.replace(select, "").trim();
//
//            w.findWeather(args);
//            return;
//        }
//        if (select.equalsIgnoreCase("forecast")) {
//            WeatherApp w = new WeatherApp(app, "Forecast");
//            args = cmd.replace(select, "").trim();
//            w.findForecast(args);
//            return;
//        }

        // System Info Commands
//        if (select.equalsIgnoreCase("cpu")) {
//            com.shivishbrahma.tilottama.main.util.OSSystem.details();
//            return;
//        }
//        if (select.equalsIgnoreCase("os")) {
//            com.shivishbrahma.tilottama.main.util.OSSystem.osInfo();
//            return;
//        }
        // IP
//        if (select.equalsIgnoreCase("ip")) {
//            com.shivishbrahma.tilottama.main.util.OSSystem.ipInfo();
//            return;
//        }
//        if (select.equalsIgnoreCase("user")) {
//            com.shivishbrahma.tilottama.main.util.OSSystem.userInfo();
//            return;
//        }
//        if (select.equalsIgnoreCase("java")) {
//            com.shivishbrahma.tilottama.main.util.OSSystem.javaDetails();
//            return;
//        }
//        if (select.equalsIgnoreCase("sysinfo")) {
//            try {
//                com.shivishbrahma.tilottama.main.util.OSSystem.systemInfo();
//            } catch (IOException e) {
//                // TODO Auto-generated catch block
//                e.printStackTrace();
//            }
//            return;
//        }

        // System Commands
        // if (select.equalsIgnoreCase("today")) {
        //     try {
        //         com.shivishbrahma.tilottama.main.util.OSCommand.today();
        //     } catch (IOException e) {
        //         // TODO Auto-generated catch block
        //         e.printStackTrace();
        //     }
        //     return;
        // }

        // Converter app
//        if (select.equalsIgnoreCase("currency")) {
//            CurrencyConvertor c = new CurrencyConvertor(app, "Currency");
//            args = cmd.replace(select, "").trim();
//            c.convertCurrency(args);
//            return;
//        }
//
//        if (select.equalsIgnoreCase("temperature")) {
//            args = cmd.replaceAll(select, "").trim();
//            com.shivishbrahma.tilottama.main.par.Temperature.temperatureConv(args);
//            return;
//        }

        // Wiki
//        if (select.equalsIgnoreCase("wiki")) {
//            args = cmd.replaceAll(select, "").trim();
//            Wiki wk = new Wiki(args);
//            wk.details();
//            return;
//        }

        args = cmd.replaceAll(select, "").trim();

        GameController mg = new GameController();
        findAndRunService(cmd, args, mg);

        // Gui
//        if (select.equalsIgnoreCase("gui")) {
//            args = cmd.replaceAll(select, "").trim();
//            if (args.equalsIgnoreCase("") || !app.getFrames().containsKey(args)) {
//                Gui gui = new Gui(app);
//                gui.setVisible(true);
//            } else {
//                app.getFrames().get(args).setVisible(true);
//            }
//        }

    }

    public static Map<String, Object> parseArgs(ArgAnnotate[] argsConfig, String argsString) {
        StringTokenizer tokenizer = new StringTokenizer(argsString);
        Map<String, Object> argsMap = new HashMap<>();
        Arg arg = null;
        String token, argName, argValue;

        for (ArgAnnotate argConfig : argsConfig) {
            Class dataType = argConfig.dataType();
            Object dataVal;
            if (dataType.equals(Integer.class)) {
                dataVal = Integer.parseInt(argConfig.dataDefault());
            } else if (dataType.equals(Double.class)) {
                dataVal = Double.parseDouble(argConfig.dataDefault());
            } else if (dataType.equals(Float.class)) {
                dataVal = Float.parseFloat(argConfig.dataDefault());
            } else {
                dataVal = argConfig.dataDefault();
            }
            argsMap.put(argConfig.name(), dataVal);
        }

        String[] argsName = argsMap.keySet().toArray(new String[0]);
        while (tokenizer.hasMoreTokens()) {
            token = tokenizer.nextToken();
            argName = argValue = "";
            if (token.startsWith("--")) {
                argName = token.substring(2);
                if (!tokenizer.hasMoreTokens()) {
                    rootLogger.severe(String.format("Missing value for %s", argName));
                }
            }

        }

        return argsMap;
    }

    public static void findAndRunService(String cmd, String argsString, Object obj) {
        Method[] methods = obj.getClass().getDeclaredMethods();
        for (Method m : methods) {
            CommandAnnotate cmdAnnotation = m.getAnnotation(CommandAnnotate.class);
            if (cmdAnnotation != null) {
                // Check if matches with name or aliases
                if (cmdAnnotation.name().equalsIgnoreCase(cmd) || Arrays.stream(cmdAnnotation.alias())
                        .anyMatch(str -> str.equalsIgnoreCase(cmd))) {
                    try {
                        ArgAnnotate[] argsConfig = cmdAnnotation.args();
                        if (argsConfig.length >= 0) {
                            Map<String, Object> argsMap = parseArgs(argsConfig, argsString);
                        }
//                        m.invoke(obj);
                    } catch (Exception e) {
                        rootLogger.severe(e.getMessage());
                    }
                }
            }
        }
    }

}
