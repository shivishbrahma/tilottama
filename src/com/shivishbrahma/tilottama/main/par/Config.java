package com.shivishbrahma.tilottama.main.par;

import java.util.ArrayList;

/**
 *
 * @author Purbayan Chowdhury
 *         (<a href=
 *         "https://shivishbrahma.github.io/">shivishbrahma.github.io</a>)
 */
public class Config {
    String key, url, source;
    ArrayList<Args> args;

    public Config(String key, ArrayList<Args> args, String url, String source) {
        this.key = key;
        this.url = url;
        this.args = args;
        this.source = source;
    }

    public Config(String key, ArrayList<Args> args, String url) {
        this(key, args, url, "");
    }

    public Config() {
        this("", new ArrayList<Args>(), "", "");
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArrayList<Args> getArgs() {
        return args;
    }

    public void setArgs(ArrayList<Args> args) {
        this.args = args;
    }

    @Override
    public String toString() {
        String res = "Config:\t";
        if (!this.key.equals(""))
            res = String.format("%sAPI_Key : \t%s\t", res, this.key);
        if (!this.url.equals(""))
            res = String.format("%s|\tURL : \t%s\n", res, this.url);
        if (this.args.size() > 0) {
            for (Args a : args)
                res = String.format("%s%s\n", res, a);
        }
        return res.trim();
    }

}
