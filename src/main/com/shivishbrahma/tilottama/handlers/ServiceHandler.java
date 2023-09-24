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
import com.shivishbrahma.tilottama.controllers.SystemController;

/**
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 */
public class ServiceHandler {
    static Logger rootLogger = Logger.getLogger(ServiceHandler.class.getName());

    /**
     * @param app App
     * @param cmd String
     */
    public static void findAndRun(App app, String command) {
        // StringTokenizer token = new StringTokenizer(cmd);
        // String args, select;
        // select = token.nextToken();
        // Weather App
        // if (select.equalsIgnoreCase("weather")) {
        // WeatherApp w = new WeatherApp(app, "Weather");
        // args = cmd.replace(select, "").trim();
        //
        // w.findWeather(args);
        // return;
        // }
        // if (select.equalsIgnoreCase("forecast")) {
        // WeatherApp w = new WeatherApp(app, "Forecast");
        // args = cmd.replace(select, "").trim();
        // w.findForecast(args);
        // return;
        // }

        // System Info Commands
        // if (select.equalsIgnoreCase("cpu")) {
        // com.shivishbrahma.tilottama.main.util.OSSystem.details();
        // return;
        // }
        // if (select.equalsIgnoreCase("os")) {
        // com.shivishbrahma.tilottama.main.util.OSSystem.osInfo();
        // return;
        // }
        // IP
        // if (select.equalsIgnoreCase("ip")) {
        // com.shivishbrahma.tilottama.main.util.OSSystem.ipInfo();
        // return;
        // }
        // if (select.equalsIgnoreCase("user")) {
        // com.shivishbrahma.tilottama.main.util.OSSystem.userInfo();
        // return;
        // }
        // if (select.equalsIgnoreCase("java")) {
        // com.shivishbrahma.tilottama.main.util.OSSystem.javaDetails();
        // return;
        // }
        // if (select.equalsIgnoreCase("sysinfo")) {
        // try {
        // com.shivishbrahma.tilottama.main.util.OSSystem.systemInfo();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // return;
        // }

        // System Commands
        // if (select.equalsIgnoreCase("today")) {
        // try {
        // com.shivishbrahma.tilottama.main.util.OSCommand.today();
        // } catch (IOException e) {
        // // TODO Auto-generated catch block
        // e.printStackTrace();
        // }
        // return;
        // }

        // Converter app
        // if (select.equalsIgnoreCase("currency")) {
        // CurrencyConvertor c = new CurrencyConvertor(app, "Currency");
        // args = cmd.replace(select, "").trim();
        // c.convertCurrency(args);
        // return;
        // }
        //
        // if (select.equalsIgnoreCase("temperature")) {
        // args = cmd.replaceAll(select, "").trim();
        // com.shivishbrahma.tilottama.main.par.Temperature.temperatureConv(args);
        // return;
        // }

        // Wiki
        // if (select.equalsIgnoreCase("wiki")) {
        // args = cmd.replaceAll(select, "").trim();
        // Wiki wk = new Wiki(args);
        // wk.details();
        // return;
        // }

        if (findAndRunService(app, command, SystemController.class))
            return;

        if (findAndRunService(app, command, GameController.class))
            return;

        // Gui
        // if (select.equalsIgnoreCase("gui")) {
        // args = cmd.replaceAll(select, "").trim();
        // if (args.equalsIgnoreCase("") || !app.getFrames().containsKey(args)) {
        // Gui gui = new Gui(app);
        // gui.setVisible(true);
        // } else {
        // app.getFrames().get(args).setVisible(true);
        // }
        // }

    }

    private static Object[] parseArgs(App app, ArgAnnotate[] argsConfig, StringTokenizer commandTokenizer) {
        Map<String, Object> argsMap = new HashMap<>();
        String token, argName, argValue;
        int argIndex = 0;

        String[] quotes = app.getConstantsProperties().getProperty("service.quotes").split("");

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
        while (commandTokenizer.hasMoreTokens()) {
            token = commandTokenizer.nextToken();
            argName = argValue = "";
            if (token.startsWith("--")) {
                argName = token.substring(2);
                if (!commandTokenizer.hasMoreTokens()) {
                    rootLogger.severe(String.format("Missing value for %s", argName));
                }
                // If the first token is argName, so nextToken should be argValue
                argValue = token = commandTokenizer.nextToken();
                argIndex = -1;
            } else {
                argValue = token;
                if (argIndex == -1)
                    rootLogger.severe("Positional arguments are not allowed after parameterised arguments");
                else if (argsName.length - 1 <= argIndex)
                    argName = argsName[argIndex++];
                else
                    rootLogger.severe("No more arguments expected");
            }

            // Handling quoted strings
            for (String quote : quotes) {
                if (token.startsWith(quote)) {
                    argValue = argValue.substring(1);
                    while (!token.endsWith(quote)) {
                        token = commandTokenizer.nextToken();
                        argValue = String.format("%s %s", argValue, token);
                    }
                    argValue = argValue.substring(0, argValue.length() - 1);
                    break;
                }
            }

            if (!argName.equalsIgnoreCase("")) {
                // System.out.format("%s : %s\n", argName, argValue);
                if (argsMap.get(argName).getClass().equals(Integer.class)) {
                    argsMap.put(argName, Integer.parseInt(argValue));
                } else if (argsMap.get(argName).getClass().equals(Double.class)) {
                    argsMap.put(argName, Double.parseDouble(argValue));
                } else if (argsMap.get(argName).getClass().equals(Float.class)) {
                    argsMap.put(argName, Float.parseFloat(argValue));
                } else {
                    argsMap.put(argName, argValue);
                }
            }
        }

        // for (Map.Entry<String, Object> e : argsMap.entrySet()) {
        // System.out.format("%s %s", e.getKey(), e.getValue());
        // }

        return argsMap.values().toArray();
    }

    private static boolean findAndRunService(App app, String command, Class clazz) {
        StringTokenizer commandTokenizer = new StringTokenizer(command);
        Method[] methods = clazz.getDeclaredMethods();
        String cmd = commandTokenizer.nextToken();

        for (Method m : methods) {
            CommandAnnotate cmdAnnotation = m.getAnnotation(CommandAnnotate.class);
            // Check if matches with name or aliases
            if (cmdAnnotation != null &&
                    (cmdAnnotation.name().equalsIgnoreCase(cmd) || Arrays.stream(cmdAnnotation.alias())
                            .anyMatch(str -> str.equalsIgnoreCase(cmd)))) {
                try {
                    ArgAnnotate[] argsConfig = cmdAnnotation.args();
                    Object[] argsValue = parseArgs(app, argsConfig, commandTokenizer);

                    m.invoke(clazz, argsValue);
                    return true;
                } catch (Exception e) {
                    rootLogger.severe(e.toString());
                }
            }
        }

        return false;
    }

}
