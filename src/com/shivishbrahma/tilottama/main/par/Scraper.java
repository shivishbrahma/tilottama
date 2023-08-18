package com.shivishbrahma.tilottama.main.par;

import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import com.shivishbrahma.tilottama.main.App;

/**
 * A Web Scraper built using okhttp and gson.
 * 
 * @author Purbayan Chowdhury (<a>shivishbrahma.github.io</a>)
 */
public class Scraper {
    Logger rootLogger = Logger.getLogger(App.class.getName());

    /**
     * @param app  - Instance of the main App object
     * @param name - Name of the service to be searched
     * @return service - Service searched
     */
    public Service findService(App app, String name) {

        List<Service> sl = app.getServices().stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if (sl.size() > 0) {
            Service s = sl.get(0);
            // rootLogger.info(s.toString());
            return s;
        }
        return null;
    }

    /**
     * @param s
     * @param name
     * @return
     */
    public Args findArg(Service s, String name) {
        List<Args> arglist = s.getConfig().args.stream().filter(p -> p.getName().equalsIgnoreCase(name))
                .collect(Collectors.toList());
        if (arglist.size() > 0) {
            return arglist.get(0);
        }
        return null;
    }

    /**
     * @param s
     * @param args
     * @return
     */
    @SuppressWarnings({ "unlikely-arg-type" })
    public JsonElement getJsonRequest(Service s, String args) {
        StringTokenizer tokenizer = new StringTokenizer(args);
        String token, val = "", url = "";
        Args arg = null;
        try {
            while (tokenizer.hasMoreTokens()) {
                token = tokenizer.nextToken();
                if (token.startsWith("--"))
                    arg = findArg(s, token.substring(2));
                if (arg == null) {
                    url = url + "+" + token;
                } else {
                    if (!tokenizer.hasMoreTokens()) {
                        throw new Exception("Missing value or argument name");
                    }
                    // rootLogger.info(String.format("Arg: %s", arg.getQuery()));

                    token = val = tokenizer.nextToken();
                    String[] quotes = { "'", "\"", "`" };

                    for(String quote: quotes) {
                        if (token.startsWith(quote)) {
                            val = val.substring(1);
                            while (!token.endsWith(quote)) {
                                token = tokenizer.nextToken();
                                val = String.format("%s %s", val, token);
                            }
                            val = val.substring(0, val.length() - 1);
                            val = val.replace(" ", "+");
                        }
                    }
                    // rootLogger.info(String.format("Value: %s", val));

                    url = url + "&" + arg.getQuery() + "=";
                    if (arg.equals("Integer")) {
                        url = url + "%d";
                        url = String.format(url, Integer.parseInt(val));
                    }
                    if (arg.equals("Float")) {
                        url = url + "%f";
                        url = String.format(url, Float.parseFloat(val));
                    }
                    if (arg.equals("String")) {
                        url = url + "%s";
                        url = String.format(url, val.toString());
                    }
                    url = url + val;
                }
            }

            url = String.format(s.getConfig().url, s.getConfig().key) + url;
            // rootLogger.info(String.format("Formatted Url: %s\n", url));
            return getJsonRequest(url);
        } catch (NumberFormatException e) {
            rootLogger.severe("Invalid Type of Value\n" + e.getMessage());
            System.exit(0);
        } catch (Exception e) {
            rootLogger.severe(e.getMessage());
            System.exit(0);
        }

        return null;
    }

    /**
     * @param url
     * @return
     */
    @SuppressWarnings({ "deprecation" })
    public JsonElement getJsonRequest(String url) {
        try {
            System.setProperty("http.agent", "Netscape 1.0");

            OkHttpClient client = new OkHttpClient();
            Request req = new Request.Builder().url(url).get().build();
            Response res = client.newCall(req).execute();
            // System.out.println(res.toString());

            JsonParser jp = new JsonParser();
            if (res.code() == 200) {
                return jp.parse(res.body().string());
            } else {
                String json = String.format("{\'code\':%d, \'message\': \'%s\'}", res.code(), res.message());
                return jp.parse(json);
            }
        } catch (Exception e) {
            rootLogger.severe(e.getMessage());
            return null;
        }
    }
}
