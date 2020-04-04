package com.example.midulsterfootballleague;

import android.content.Context;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class ResultHolder extends RecyclerView.ViewHolder {

    View view;

    public ResultHolder(@NonNull View itemView) {
        super(itemView);

        view = itemView;


    }

    public void setView(Context context , String home, String score, String away, String week){

        TextView hometv = view.findViewById(R.id.Home);
        TextView scoretv = view.findViewById(R.id.Score);
        TextView awaytv = view.findViewById(R.id.Away);
        TextView gameweektv = view.findViewById(R.id.GameWeek);

        hometv.setText(home);
        scoretv.setText(score);
        awaytv.setText(away);
        gameweektv.setText(week);
    }
}
