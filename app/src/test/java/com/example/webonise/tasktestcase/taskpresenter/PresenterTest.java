package com.example.webonise.tasktestcase.taskpresenter;

import com.example.webonise.tasktestcase.model.Comments;
import com.example.webonise.tasktestcase.view.HomeScreenView;

import static org.mockito.Matchers.any;
import static org.mockito.Matchers.eq;
import static org.mockito.Mockito.inOrder;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;


import org.junit.Before;
import org.junit.Test;
import org.mockito.InOrder;


import java.util.ArrayList;

/**
 * Created by webonise on 23/9/16.
 */

public class PresenterTest {
    private Presenter presenter;

    private HomeScreenView mockfirstScreenView;
    private ArrayList<Comments> commentsArrayList=new ArrayList<>();
    private String jsonData;

    @Before
    public void setUp()
    {
        mockfirstScreenView=mock(HomeScreenView.class);
        presenter=new Presenter(mockfirstScreenView,jsonData);
        addValues();
    }

    private void addValues() {
        Comments comments;
        for(int i=0;i<10;i++)
        {
            comments=new Comments();
            comments.setBody("asff");
            comments.setEmail("wfgwfvgw");
            comments.setName("dfgvg");
            commentsArrayList.add(comments);
        }
    }

    @Test
    public void restoreData() {
        presenter.loadData();
        verify(mockfirstScreenView, times(1)).showProgressDialog();
    }


    @Test
    public void showProgressDialogAndRenderResponseAndHideDialogInOrder(){
        presenter.loadData();
        InOrder inOrder = inOrder(mockfirstScreenView);
        inOrder.verify(mockfirstScreenView).showProgressDialog();
        inOrder.verify(mockfirstScreenView).render(eq(commentsArrayList));
        inOrder.verify(mockfirstScreenView).dismissProgressDialog();
    }

    @Test
    public void dismissDialog()
    {
        presenter.loadData();
        verify(mockfirstScreenView,times(1)).dismissProgressDialog();
    }



}
