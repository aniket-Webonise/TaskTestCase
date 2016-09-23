package com.example.webonise.tasktestcase.TaskPresenter;

import com.example.webonise.tasktestcase.model.Comments;
import com.example.webonise.tasktestcase.utilities.Constants;
import com.example.webonise.tasktestcase.view.FirstScreenView;
import com.example.webonise.tasktestcase.viewModel.CommentsViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

/**
 * Created by webonise on 22/9/16.
 */

public class Presenter {

    private final FirstScreenView firstScreenView;
    private String jsonData;

    public Presenter(FirstScreenView firstScreenView,String jsonData) {
        this.firstScreenView = firstScreenView;
        this.jsonData=jsonData;
    }
    public void loadData() {
        firstScreenView.showProgressDialog();
        ArrayList<Comments> commentsArrayList=new ArrayList<>();
        ArrayList<Comments> changeArray=new ArrayList<>();
        if(jsonData!=null)
        {
            try {
                JSONArray jsonArray = new JSONArray(jsonData);
                Comments comments;
                for(int i=0;i<jsonArray.length();i++)
                {
                    comments=new Comments();
                    JSONObject jsonObject=jsonArray.getJSONObject(i);
                    comments.setName(jsonObject.getString(Constants.NAME_LIST));
                    comments.setEmail(jsonObject.getString(Constants.EMAIL_LIST));
                    comments.setBody(jsonObject.getString(Constants.BODY_LIST));
                    commentsArrayList.add(comments);
                }
                CommentsViewModel viewModel=new CommentsViewModel(commentsArrayList);
                changeArray=viewModel.validateData();
                firstScreenView.render(changeArray);
                firstScreenView.dismissProgressDialog();

            }catch (JSONException e)
            {
                e.printStackTrace();
            }
        }else
        {
            firstScreenView.dismissProgressDialog();
            firstScreenView.showErrorDialog(Constants.ERROR_MSG);

        }

//        Comments comments=new Comments();
//        comments.setName("id labore ex et quam laborum");
//        comments.setEmail("Eliseo@gardner.biz");
//        comments.setBody("laudantium enim quasi est quidem magnam voluptate ipsam eos\\ntempora quo necessitatibus\\ndolor quam autem quasi\\nreiciendis et nam sapiente accusantium");
//        commentsArrayList.add(comments);
//
//        comments=new Comments();
//        comments.setName("quo vero reiciendis velit similique earum");
//        comments.setEmail("Jayne_Kuhic@sydney.com");
//        comments.setBody("est natus enim nihil est dolore omnis voluptatem numquam\\net omnis occaecati quod ullam at\\n voluptatem error expedita pariatur\\n nihil sint nostrum voluptatem reiciendis et");
//        commentsArrayList.add(comments);
//
//        comments=new Comments();
//        comments.setName("odio adipisci rerum aut animi");
//        comments.setEmail("Nikita@garfield.biz");
//        comments.setBody("quia molestiae reprehenderit quasi aspernatur\\naut expedita occaecati aliquam eveniet laudantium\\nomnis quibusdam delectus saepe quia accusamus maiores nam est\\ncum et ducimus et vero voluptates excepturi deleniti ratione");
//        commentsArrayList.add(comments);
//
//        comments=new Comments();
//        comments.setName("alias odio sit");
//        comments.setEmail("Lew@alysha.tv");
//        comments.setBody("non et atque\\noccaecati deserunt quas accusantium unde odit nobis qui voluptatem\\nquia voluptas consequuntur itaque dolor\\net qui rerum deleniti ut occaecati");
//        commentsArrayList.add(comments);
//
//
//        comments=new Comments();
//        comments.setName("vero eaque aliquid doloribus et culpa");
//        comments.setEmail("Hayden@althea.biz");
//        comments.setBody("harum non quasi et ratione\\ntempore iure ex voluptates in ratione\\nharum architecto fugit inventore cupiditate\\nvoluptates magni quo et");
//        commentsArrayList.add(comments);
//
//        comments=new Comments();
//        comments.setName("et fugit eligendi deleniti quidem qui sint nihil autem");
//        comments.setEmail("Presley.Mueller@myrl.com");
//        comments.setBody("doloribus at sed quis culpa deserunt consectetur qui praesentium\\naccusamus fugiat dicta\\nvoluptatem rerum ut voluptate");
//        commentsArrayList.add(comments);
//
//        comments=new Comments();
//        comments.setName("repellat consequatur praesentium vel minus molestias voluptatum");
//        comments.setEmail("Dallas@ole.me");
//        comments.setBody("maiores sed dolores similique labore et inventore et\\nquasi temporibus esse sunt id et\\neos voluptatem aliquam\\naliquid ratione corporis");
//        commentsArrayList.add(comments);



    }




}
