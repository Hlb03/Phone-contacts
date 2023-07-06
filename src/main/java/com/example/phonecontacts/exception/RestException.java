package com.example.phonecontacts.exception;

import java.util.Date;

public class RestException {

    private final int statusCode;
    private final String description;
    private final Date date;

    public RestException(int statusCode, String description) {
        this.statusCode = statusCode;
        this.description = description;
        this.date = new Date();
    }

    public int getStatusCode() {
        return statusCode;
    }

    public String getDescription() {
        return description;
    }

    public Date getDate() {
        return date;
    }
}
