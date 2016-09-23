package com.example.webonise.tasktestcase.viewModel;

import com.example.webonise.tasktestcase.model.Comments;

import java.lang.reflect.Array;
import java.util.ArrayList;

/**
 * Created by webonise on 22/9/16.
 */

public class CommentsViewModel {
    private  ArrayList<Comments> commentsArrayList=new ArrayList<>();
    private  ArrayList<Comments> changeArrayList=new ArrayList<>();
    public CommentsViewModel(ArrayList<Comments> commentsArrayList)
    {
        this.commentsArrayList=commentsArrayList;
    }

    public ArrayList<Comments> validateData()
    {
        Comments comments;
        for(int i=0;i<commentsArrayList.size();i++)
        {
            comments=new Comments();

            String name=splitData(commentsArrayList.get(i).getName());
            comments.setName(name);
            comments.setEmail(lowerCase(commentsArrayList.get(i).getEmail()));
            comments.setBody(commentsArrayList.get(i).getBody());
            Boolean length=splitDataToCheckLength(commentsArrayList.get(i).getName());
            if(!length)
            {
                comments.setLengthIncreases("No");
            }else
            {
                comments.setLengthIncreases("Yes");

            }
            changeArrayList.add(comments);

        }
        return changeArrayList;
    }


    public String splitData(String name)
    {
        if(name!=null) {
            String[] parts = name.split(" ");
            return parts[0] + " " + parts[1] + " " + parts[2];
        }else
        {
            return null;
        }
    }


    public boolean splitDataToCheckLength(String name)
    {
        if(name!=null) {

            String[]  parts = name.split(" ");
            try {
                if (parts[3] == null) {
                    return true;
                } else {
                    return false;
                }
            }catch(Exception e)
            {
                e.printStackTrace();
                return true;
            }
        }else
        {
            return false;
        }
    }

    public String lowerCase(String email)
    {
        String emailLowerCase=email.toLowerCase();
        return emailLowerCase;
    }
}
