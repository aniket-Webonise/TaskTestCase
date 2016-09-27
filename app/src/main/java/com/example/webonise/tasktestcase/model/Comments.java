package com.example.webonise.tasktestcase.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

/**
 * Created by webonise on 22/9/16.
 */

public class Comments {
    public String name;
    public String email;
    public String body;


    @SerializedName("comments")
    private ArrayList<Comments> commentsArrayList;


    public ArrayList<Comments> getCommentsArrayList() {
        return commentsArrayList;
    }

    public void setManagers(ArrayList<Comments> commentsArrayList) {
        this.commentsArrayList = commentsArrayList;
    }



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
