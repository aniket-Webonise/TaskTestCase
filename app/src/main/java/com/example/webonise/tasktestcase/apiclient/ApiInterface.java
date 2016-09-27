package com.example.webonise.tasktestcase.apiclient;

import com.example.webonise.tasktestcase.model.Comments;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


/**
 * Created by webonise on 27/9/16.
 */

public interface ApiInterface {

    @GET("comments")
    public  Call <List<Comments>> getCommentsArrayList();

}
