package com.example.webonise.tasktestcase.model;

import java.util.Arrays;
import java.util.List;

/**
 * Created by webonise on 22/9/16.
 */

public class CommentsModel {

    private List<Comments> commentsList;

    public CommentsModel(){
    }

    public CommentsModel(Comments... commentsList){
        this.commentsList = Arrays.asList(commentsList);
    }

    public List<Comments> getSessions() {
        return commentsList;
    }
}
