package com.example.webonise.tasktestcase.viewmodel;

import com.example.webonise.tasktestcase.model.Comments;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;

/**
 * Created by webonise on 22/9/16.
 */

public class CommentsViewModelTest {


    private CommentsViewModel viewModel;



    @Before
    public void setUp(){
        viewModel =  new CommentsViewModel(new ArrayList<Comments>());
    }

    @Test
    public void testlowerCase()
    {
//        String emailNew="abc@gmail.com";
//        Assert.assertEquals("k@df.fd",viewModel.lowerCase("K@DF.FD"));
        Assert.assertEquals("a",viewModel.lowerCase("a"));

    }


    @Test
    public void testsplitData()
    {
//        String emailNew="abc@gmail.com";
//        Assert.assertEquals("k@df.fd",viewModel.lowerCase("K@DF.FD"));

    }

    @Test
    public void splitDataToCheckLength()
    {
        Assert.assertEquals(false,viewModel.splitDataToCheckLength("asddas adfaf sdfasf dsfgshsr"));
    }

    @Test
    public void testcontainsDigit()
    {
        Assert.assertEquals(true,viewModel.containsDigit("abc123"));
    }

    @Test
    public void testemailBlank()
    {
        Assert.assertEquals(true,viewModel.emailBlank(""));
    }

    @Test
    public void testvalidateEmail()
    {
        Assert.assertEquals(true,viewModel.validateEmail("abc@gmail.com"));
    }

}
