package com.example.midulsterfootballleague;

public class League {
    String Goals;
    String Played;
    String Points;
    String Position;
    String teamName;

    public League(){

    }

    public String getGoals() { return Goals; }

    public void setGoals(String goals) {
        Goals = goals;
    }

    public String getPlayed() {
        return Played;
    }

    public void setPlayed(String played) {
        Played = played;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
