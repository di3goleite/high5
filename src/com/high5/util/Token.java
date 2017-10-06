package com.high5.util;

public class Token {
    private String key;
    private String value;

    public Token(String key, String value) {
        this.key = key;
        this.value = value;
    }

    public String getToken() {
        return "<" + this.key + ", " + this.value + ">";
    }
}
