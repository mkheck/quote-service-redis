package com.example;

import java.io.Serializable;

/**
 * Created by markheckler on 10/12/16.
 */
public class Quote implements Serializable {
    private String text;
    private String source;

    public Quote(String text, String source) {
        this.text = text;
        this.source = source;
    }

    public String getText() {
        return text;
    }

    public String getSource() {
        return source;
    }

    @Override
    public String toString() {
        return "Quote{" +
                "text='" + text + '\'' +
                ", source='" + source + '\'' +
                '}';
    }
}
