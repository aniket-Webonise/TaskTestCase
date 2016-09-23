package com.example.webonise.tasktestcase.model;

/**
 * Created by webonise on 22/9/16.
 */

public class Comments {
    public String name;
    public String email;
    public String body;

    public String getLengthIncreases() {
        return lengthIncreases;
    }

    public void setLengthIncreases(String lengthIncreases) {
        this.lengthIncreases = lengthIncreases;
    }

    public String lengthIncreases;

    public void setName(String name) {
        this.name = name;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public String getBody() {
        return body;
    }


}
