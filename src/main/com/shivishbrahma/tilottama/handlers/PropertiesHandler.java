package com.shivishbrahma.tilottama.handlers;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesHandler {
    private Properties properties;

    public PropertiesHandler(String propertyFileName) throws IOException {
        InputStream is = this.getClass().getClassLoader()
                .getResourceAsStream(propertyFileName);
        this.properties = new Properties();
        this.properties.load(is);
    }

    public String getProperty(String propertyName) {
        return this.properties.getProperty(propertyName);
    }

    public static InputStream getResourceStream(String fileName) {
        InputStream is = PropertiesHandler.class.getClassLoader().getResourceAsStream(fileName);
        return is;
    }
}
