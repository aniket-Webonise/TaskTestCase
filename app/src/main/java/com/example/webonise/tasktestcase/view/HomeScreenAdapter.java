package com.example.webonise.tasktestcase.view;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.webonise.tasktestcase.R;
import com.example.webonise.tasktestcase.model.Comments;

import java.util.ArrayList;

/**
 * Created by webonise on 22/9/16.
 */

public class HomeScreenAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private LayoutInflater layoutInflater;
    private Context context;
    private ArrayList<Comments> commentsArrayList=new ArrayList<>();
    private int lastPosition = -1;
  /*  public HomeScreenAdapter(Context context, ArrayList<Comments> commentsArrayList) {
        this.context = context;
        this.commentsArrayList=commentsArrayList;
        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }*/

    public HomeScreenAdapter( ArrayList<Comments> commentsArrayList) {

        this.commentsArrayList=commentsArrayList;
       // layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }


    public class CviewHolder extends RecyclerView.ViewHolder {
        TextView nameText, emailText,bodyText;
        LinearLayout linearLayout;


        public CviewHolder(View view) {
            super(view);
            nameText= (TextView) view.findViewById(R.id.text_view_name);
            emailText= (TextView) view.findViewById(R.id.text_view_email);
            bodyText= (TextView) view.findViewById(R.id.text_view_body);
            linearLayout= (LinearLayout) view.findViewById(R.id.container);
        }

    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder viewHolder = null;
        View v2 = LayoutInflater.from(parent.getContext()).inflate(R.layout.recycler_list_item, parent, false);
        context = v2.getContext();
        //View v2 = layoutInflater.inflate(R.layout.recycler_list_item, parent, false);
        viewHolder = new CviewHolder(v2);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        CviewHolder vh2 = (CviewHolder) holder;
        if(commentsArrayList.get(position).getLengthIncreases().equalsIgnoreCase("No"))
        {
            vh2.nameText.setText(commentsArrayList.get(position).getName()+"...");
        }else
        {
            vh2.nameText.setText(commentsArrayList.get(position).getName());
        }

        vh2.emailText.setText(commentsArrayList.get(position).getEmail());
        vh2.bodyText.setText(commentsArrayList.get(position).getBody());
        setAnimation(((CviewHolder) holder).linearLayout,position);

    }


    private void setAnimation(View viewToAnimate, int position)
    {
        // If the bound view wasn't previously displayed on screen, it's animated
        if (position > lastPosition)
        {
            Animation animation = AnimationUtils.loadAnimation(context, android.R.anim.slide_in_left);
            viewToAnimate.startAnimation(animation);
            lastPosition = position;
        }
    }

    @Override
    public int getItemCount() {
        return commentsArrayList.size();
    }
}
