package com.shivishbrahma.tilottama.models;

/**
 * Wrapper Object to take arguments for command line app.
 *
 * @author Purbayan Chowdhury (<a href=
 * "https://shivishbrahma.github.io/">shivishbrahma.github.io</a>)
 */
public class Arg extends Object {
    private String name, type, query;

    public Arg() {
        this.name = "";
        this.type = "";
        this.query = "";
    }

    /**
     * Parameterized constructor for Args class
     *
     * @param name  - Name of the argument
     * @param type  - Data type of the argument
     * @param query - Query associated with the argument for API call
     */
    public Arg(String name, String type, String query) {
        this.name = name;
        this.type = type;
        this.query = query;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the type
     */
    public String getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(String type) {
        this.type = type;
    }

    /**
     * @return the query
     */
    public String getQuery() {
        return query;
    }

    /**
     * @param query the query to set
     */
    public void setQuery(String query) {
        this.query = query;
    }

    @Override
    public String toString() {
        String res = String.format("Args: %s\nType: %s\nQuery: %s\n", this.name, this.type, this.query);
        return res.trim();
    }

}
