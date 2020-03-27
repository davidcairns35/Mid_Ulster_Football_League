package com.example.midulsterfootballleague;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;

    private LeagueAdapter leagueAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<League> leagues, List<String> keys){
        mContext = context;
        leagueAdapter = new LeagueAdapter(leagues, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(leagueAdapter);
    }

    class  LeagueItemView extends RecyclerView.ViewHolder{
        private TextView position;
        private TextView played;
        private TextView name;
        private TextView points;
        private TextView goals;

        private String key;

        public LeagueItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.league_table_item,parent, false));

            position = (TextView) itemView.findViewById(R.id.Position);
            played = (TextView) itemView.findViewById(R.id.Played);
            name = (TextView) itemView.findViewById(R.id.TeamName);
            points = (TextView) itemView.findViewById(R.id.Points);
            goals = (TextView) itemView.findViewById(R.id.Goals);
        }

        public void bind(League league, String key){
            position.setText(league.getPosition());
            played.setText(league.getPlayed());
            name.setText(league.getTeamName());
            points.setText(league.getPoints());
            goals.setText(league.getGoals());
            this.key = key;
        }
    }
    class LeagueAdapter extends RecyclerView.Adapter<LeagueItemView>{
        private List<League> leagueList;
        private  List<String> mKeys;

        public LeagueAdapter(List<League> leagueList, List<String> mKeys) {
            this.leagueList = leagueList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public LeagueItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new LeagueItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull LeagueItemView holder, int position) {
            holder.bind(leagueList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return leagueList.size();
        }
    }
}
