package com.example.midulsterfootballleague;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class Holder extends RecyclerView.ViewHolder {

    View view;

    public Holder(@NonNull View itemView) {
        super(itemView);

        view = itemView;


    }

    public void setView(Context context , String Position, String Goals, String Points, String Played, String teamName){

        TextView positiontv = view.findViewById(R.id.Position);
        TextView nametv = view.findViewById(R.id.TeamName);
        TextView playedtv = view.findViewById(R.id.Played);
        TextView goalstv = view.findViewById(R.id.Goals);
        TextView pointstv = view.findViewById(R.id.Points);

        positiontv.setText(Position);
        nametv.setText(teamName);
        playedtv.setText(Played);
        goalstv.setText(Goals);
        pointstv.setText(Points);
    }
}
