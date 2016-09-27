package com.example.webonise.tasktestcase.taskpresenter;

import android.util.Log;

import com.example.webonise.tasktestcase.apiclient.ApiClient;
import com.example.webonise.tasktestcase.apiclient.ApiInterface;
import com.example.webonise.tasktestcase.model.Comments;
import com.example.webonise.tasktestcase.utilities.Constants;
import com.example.webonise.tasktestcase.view.HomeScreenView;
import com.example.webonise.tasktestcase.viewmodel.CommentsViewModel;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by webonise on 22/9/16.
 */

public class Presenter {

    private final HomeScreenView homeScreenView;
    private String jsonData;

    public Presenter(HomeScreenView homeScreenView, String jsonData) {
        this.homeScreenView = homeScreenView;
        this.jsonData=jsonData;
    }

    /** method to fetch data from server */
    public void loadData() {
        homeScreenView.showProgressDialog();
        final ArrayList<Comments> commentsArrayList=new ArrayList<>();


        ApiInterface apiService =
                ApiClient.getClient().create(ApiInterface.class);

        Call<List<Comments>> call = apiService.getCommentsArrayList();

        call.enqueue(new Callback<List<Comments>>() {
            @Override
            public void onResponse(Call<List<Comments>> call, Response<List<Comments>> response) {

                Log.e("OnResponce", "OK");
                if (response.isSuccessful()){
                   commentsArrayList.addAll(response.body());
                    ArrayList<Comments> changeArray=new ArrayList<>();
                    CommentsViewModel viewModel=new CommentsViewModel(commentsArrayList);
                    changeArray=viewModel.validateData();
                    homeScreenView.render(changeArray);
                    homeScreenView.dismissProgressDialog();
                }
                else Log.e("Response", "Not ok");
            }

            @Override
            public void onFailure(Call<List<Comments>> call, Throwable t) {
                Log.e("OnFailure", "Fail");
                homeScreenView.dismissProgressDialog();
                homeScreenView.showErrorDialog(Constants.ERROR_MSG);
            }
        });

       /* if(jsonData!=null)
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
                homeScreenView.render(changeArray);
                homeScreenView.dismissProgressDialog();

            }catch (JSONException e)
            {
                e.printStackTrace();
            }
        }else
        {
            homeScreenView.dismissProgressDialog();
            homeScreenView.showErrorDialog(Constants.ERROR_MSG);

        }*/
    }




}
