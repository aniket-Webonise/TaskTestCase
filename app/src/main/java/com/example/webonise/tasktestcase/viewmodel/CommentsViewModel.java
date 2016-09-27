package com.example.webonise.tasktestcase.viewmodel;

import com.example.webonise.tasktestcase.model.Comments;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by webonise on 22/9/16.
 */

public class CommentsViewModel {
    private  ArrayList<Comments> commentsArrayList=new ArrayList<>();
    private  ArrayList<Comments> changeArrayList=new ArrayList<>();
    String regex = "^[\\w!#$%&'*+/=?`{|}~^-]+(?:\\.[\\w!#$%&'*+/=?`{|}~^-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,6}$";
    public CommentsViewModel(ArrayList<Comments> commentsArrayList)
    {
        this.commentsArrayList=commentsArrayList;
    }



    /** method to set appropriate data in model with validation*/
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


    /** method to split names such that only 3 can be used */


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

    /** method to check if the size of the name string is greater than three word count */

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


    /** method to convert the email into lowercase  */

    public String lowerCase(String email)
    {
        String emailLowerCase=email.toLowerCase();
        return emailLowerCase;
    }


    /** method to check if name contains numbers or not if contains number then invalidate  */

    public final boolean containsDigit(String s) {
        boolean containsDigit = false;

        if (s != null && !s.isEmpty()) {
            for (char c : s.toCharArray()) {
                if (containsDigit = Character.isDigit(c)) {
                    break;
                }
            }
        }

        return containsDigit;
    }

    /** method to check if email is blank or not if blank then return false */

    public boolean emailBlank(String email)
    {
        if(email.length()==0)
        {
            return true;
        }
            else
        {
            return false;
        }

    }


    /** method to check email is valid or not */
    public boolean validateEmail(String emails) {
        Pattern pattern;
        pattern = Pattern.compile(regex);


            Matcher matcher = pattern.matcher(emails);
            return matcher.matches();

    }
}
