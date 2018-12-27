package com.example.urvish.demo.Model;

public class Quote_list {

    public static final String TABLE_NAME = "quote_list";
    public static final String QUOTE_TITLE = "quote_title";
    public static final String QUOTE_DESCRIPTION = "quote_description";

    public String quote_title;
    public String quote_description;

    // Create table SQL query
    public static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME + "(" + QUOTE_TITLE + " TEXT," + QUOTE_DESCRIPTION + " TEXT" + ")";

    public Quote_list() {

    }

    public Quote_list(String quote_title, String quote_description) {
        this.quote_title = quote_title;
        this.quote_description = quote_description;
    }

    public String getQuote_title() {
        return quote_title;
    }

    public void setQuote_title(String quote_title) {
        this.quote_title = quote_title;
    }

    public String getQuote_description() {
        return quote_description;
    }

    public void setQuote_description(String quote_description) {
        this.quote_description = quote_description;
    }
}
