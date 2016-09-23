package com.example.webonise.tasktestcase.view;

import android.app.ProgressDialog;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.Toast;

import com.example.webonise.tasktestcase.R;
import com.example.webonise.tasktestcase.TaskPresenter.Presenter;
import com.example.webonise.tasktestcase.model.Comments;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;

public class FirstScreenActivity extends AppCompatActivity implements FirstScreenView {

    private ProgressDialog progressDialog;
    private RecyclerView recyclerView;
    private FirstScreenAdapter firstScreenAdapter;
    private Presenter firstScreenPresenter;
    private String jsonData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_screen);
        initialize();
        jsonData=LoadData("jsondata.txt");
        firstScreenPresenter=new Presenter(this,jsonData);
        firstScreenPresenter.loadData();


    }

    private void initialize() {
        Toolbar mToolbar = (Toolbar) findViewById(R.id.toolbar);
        recyclerView= (RecyclerView) findViewById(R.id.list_by_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        setSupportActionBar(mToolbar);
        ActionBar supportActionBar = getSupportActionBar();
        supportActionBar.setTitle(R.string.test_case_task);
        supportActionBar.setHomeButtonEnabled(true);
        supportActionBar.setDisplayHomeAsUpEnabled(true);
    }


    @Override
    public void render(ArrayList<Comments> commentses) {
        firstScreenAdapter=new FirstScreenAdapter(FirstScreenActivity.this,commentses);
        recyclerView.setAdapter(firstScreenAdapter);
        firstScreenAdapter.notifyDataSetChanged();

    }

    @Override
    public void dismissProgressDialog() {
        progressDialog.dismiss();

    }

    @Override
    public void showProgressDialog() {

        progressDialog = new ProgressDialog(this);
        progressDialog.setMessage(getResources().getString(R.string.loading));
        progressDialog.setCancelable(false);
        progressDialog.show();

    }

    @Override
    public void showErrorDialog(String eq) {
        Toast.makeText(this,eq,Toast.LENGTH_LONG).show();

    }


    public String LoadData(String inFile) {
        String tContents = "";

        try {
            InputStream stream = getAssets().open(inFile);

            int size = stream.available();
            byte[] buffer = new byte[size];
            stream.read(buffer);
            stream.close();
            tContents = new String(buffer);
        } catch (IOException e) {
            // Handle exceptions here
        }

        return tContents;

    }
}
