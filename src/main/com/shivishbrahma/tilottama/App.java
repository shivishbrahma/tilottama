package com.shivishbrahma.tilottama;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;
import java.util.Locale;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;

import com.shivishbrahma.tilottama.gui.About;
import com.shivishbrahma.tilottama.gui.Calculator;
import com.shivishbrahma.tilottama.gui.Converter;
import com.shivishbrahma.tilottama.gui.Notepad;
import com.shivishbrahma.tilottama.handlers.PropertiesHandler;
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
    private String name;
    private String version;
    private List<Service> services;
    private List<String> authors = new ArrayList<>();
    private Map<String, JFrame> frames = new HashMap<>();
    private ImageIcon icon;
    private PropertiesHandler appProperties;
    private PropertiesHandler constantsProperties;

    App() {
        Locale locale = new Locale("en", "IN");
        Locale.setDefault(locale);

        try {
            appProperties = new PropertiesHandler("properties/app.properties");
            constantsProperties = new PropertiesHandler("properties/constants.properties");
            this.setName(appProperties.getProperty("app.name"));
            this.setVersion(appProperties.getProperty("app.version"));
            this.addAuthor("Purbayan Chowdhury");
            this.setIcon(new ImageIcon(this.getClass().getResource("/images/icon.png")));
        } catch (Exception e) {
        }
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
        try {
            InputStreamReader fr = new InputStreamReader(PropertiesHandler.getResourceStream("data/config.json"));
            BufferedReader br = new BufferedReader(fr);

            logger.info("Read successfully!");

            Type arrayListType = new TypeToken<ArrayList<Service>>() {
            }.getType();
            this.services = gson.fromJson(br, arrayListType);
            // for (Service i : this.services)
            // logger.info(i.toString());
        } catch (Exception e) {
            logger.severe(e.toString());
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
            return br.readLine();
        } catch (IOException e) {
            logger.severe(e.toString());
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

    /**
     * 
     * @return Map<String, JFrame>
     */
    public Map<String, JFrame> getFrames() {
        return frames;
    }

    /**
     * 
     * @param frames Map<String, JFrame>
     */
    public void setFrames(Map<String, JFrame> frames) {
        this.frames = frames;
    }

    /**
     * 
     * @return ImageIcon
     */
    public ImageIcon getIcon() {
        return icon;
    }

    /**
     * 
     * @param icon ImageIcon
     */
    public void setIcon(ImageIcon icon) {
        this.icon = icon;
    }

    /**
     * 
     * @return List<String>
     */
    public List<String> getAuthors() {
        return authors;
    }

    /**
     * 
     * @param authors List<String>
     */
    public void setAuthors(List<String> authors) {
        this.authors = authors;
    }

    /**
     * 
     * @param author String
     */
    public void addAuthor(String author) {
        this.authors.add(author);
    }

    /**
     * 
     * @return List<Service>
     */
    public List<Service> getServices() {
        return services;
    }

    /**
     * 
     * @param services List<Service>
     */
    public void setServices(List<Service> services) {
        this.services = services;
    }

    /**
     * 
     * @return PropertiesHandler
     */
    public PropertiesHandler getAppProperties() {
        return appProperties;
    }

    /**
     * 
     * @return PropertiesHandler
     */
    public PropertiesHandler getConstantsProperties() {
        return constantsProperties;
    }

    public static void main(String[] args) {
        String cmd = "";
        try {
            App app = new App();
            while (!cmd.equals("exit")) {
                cmd = app.input();
                app.callService(cmd);
            }
        } catch (Exception e) {
            logger.severe(e.toString());
        }

    }
}
