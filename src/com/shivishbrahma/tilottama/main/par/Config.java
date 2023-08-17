package com.shivishbrahma.tilottama.main.par;

import java.util.ArrayList;

/**
 *
 * @author Purbayan Chowdhury
 *         (<a href=
 *         "https://shivishbrahma.github.io/">shivishbrahma.github.io</a>)
 */
public class Config {
    String key, url;
    ArrayList<Args> args;

    public Config() {
        this.key = "";
        this.args = new ArrayList<Args>();
        this.url = "";
    }

    public Config(String key, ArrayList<Args> args, String url) {
        this.key = key;
        this.url = url;
        this.args = args;
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
