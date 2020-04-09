package com.example.midulsterfootballleague;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class HomePageHolder extends RecyclerView.ViewHolder {

    View view;

    public HomePageHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;


    }

    public void setView(Context context , String headline, String information, String date){

        TextView headlinetv = view.findViewById(R.id.Title);
        TextView informationtv = view.findViewById(R.id.Information);
        TextView datetv = view.findViewById(R.id.Date);

        headlinetv.setText(headline);
        informationtv.setText(information);
        datetv.setText(date);
    }
}
