package com.shivishbrahma.tilottama.main;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
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

import com.shivishbrahma.tilottama.main.gui.About;
import com.shivishbrahma.tilottama.main.gui.Calculator;
import com.shivishbrahma.tilottama.main.gui.Converter;
import com.shivishbrahma.tilottama.main.gui.Notepad;
import com.shivishbrahma.tilottama.main.par.Config;
import com.shivishbrahma.tilottama.main.par.Service;
import com.shivishbrahma.tilottama.main.par.ServiceHandler;

/**
 * Tilottama main class and its starting point
 * 
 * @author Purbayan Chowdhury<a href=
 *         "mailto:pur.cho.99@gmail.com">pur.cho.99@gmail.com</a>
 *
 */
public class App {
    private static final Logger logger = Logger.getLogger(App.class.getName());

    private ArrayList<Service> services;
    private String APP_NAME, version;
    private ArrayList<String> authors = new ArrayList<>();
    private Map<String, JFrame> frames = new HashMap<>();
    private ImageIcon APP_ICON;

    public ArrayList<Service> getServices() {
        return services;
    }

    App() {
        // String currentDir = System.getProperty("user.dir");
        // System.setProperty("log4j.configurationFile", currentDir + "/log4j2.xml");
        Locale locale = new Locale("en", "IN");
        Locale.setDefault(locale);

        this.APP_NAME = "Tillotama(তিলোতমা)";
        this.version = "1.0.1";
        this.authors.add("Purbayan Chowdhury");
        this.authors.add("Anitesh Roy Chowdhury");
        this.authors.add("Heller Lorday");
        this.setAPP_ICON(new ImageIcon("assets/icons/icon.png"));
        this.initGuiServices();
        this.readServices();
    }

    public void initGuiServices() {
        this.frames.put("about", new About(this));
        this.frames.put("calculator", new Calculator(this));
        this.frames.put("converter", new Converter(this));
        this.frames.put("notepad", new Notepad(this));
    }

    /**
     * @return the authors
     */
    public ArrayList<String> getAuthors() {
        return authors;
    }

    /**
     * @param authors the authors to set
     */
    public void setAuthors(ArrayList<String> authors) {
        this.authors = authors;
    }

    /**
     * @return the frames
     */
    public Map<String, JFrame> getFrames() {
        return frames;
    }

    /**
     * @param frames the frames to set
     */
    public void setFrames(Map<String, JFrame> frames) {
        this.frames = frames;
    }

    /**
     * @return the APP_NAME
     */
    public String getAPP_NAME() {
        return APP_NAME;
    }

    /**
     * @param aPP_NAME the aPP_NAME to set
     */
    public void setAPP_NAME(String APP_NAME) {
        this.APP_NAME = APP_NAME;
    }

    /**
     * @return the version
     */
    public String getVersion() {
        return version;
    }

    /**
     * @param version the version to set
     */
    public void setVersion(String version) {
        this.version = version;
    }

    public ImageIcon getAPP_ICON() {
        return APP_ICON;
    }

    public void setAPP_ICON(ImageIcon APP_ICON) {
        this.APP_ICON = APP_ICON;
    }

    /**
     * 
     */
    public void readServices() {
        GsonBuilder builder = new GsonBuilder();
        Gson gson = builder.create();
        FileReader fr;
        try {
            fr = new FileReader(new File("assets/data/config.json"));
            BufferedReader br = new BufferedReader(fr);

            logger.info("Read successfully!");

            Type arrayListType = new TypeToken<ArrayList<Service>>() {
            }.getType();
            this.services = gson.fromJson(br, arrayListType);
            // for (Service i : this.services)
            //     logger.info(i.toString());

        } catch (IOException e) {
            logger.severe(e.getLocalizedMessage());
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
            logger.severe(e.getLocalizedMessage());
            return "";
        }
    }

    /**
     * @param cmd - Command string to be parsed for execution
     */
    public void callService(String cmd) {
        ServiceHandler.findAndRun(this, cmd);
    }

    public static void main(String[] args) {
        App app = new App();
        String cmd = app.input();
        app.callService(cmd);
    }
}
