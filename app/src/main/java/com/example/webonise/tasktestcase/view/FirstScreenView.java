package com.example.webonise.tasktestcase.view;

import com.example.webonise.tasktestcase.model.Comments;
import com.example.webonise.tasktestcase.model.CommentsModel;

import java.util.ArrayList;

/**
 * Created by webonise on 22/9/16.
 */

public interface FirstScreenView {
    void render(ArrayList<Comments> commentses);
    void dismissProgressDialog();
    void showProgressDialog();
    void showErrorDialog(String eq);
}
