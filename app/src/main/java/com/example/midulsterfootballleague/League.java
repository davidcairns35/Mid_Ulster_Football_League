package com.example.midulsterfootballleague;

public class League {
    String Position;
    String teamName;
    String Played;
    String Goals;
    String Points;

    public League(){

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

    public String getPlayed() {
        return Played;
    }

    public void setPlayed(String played) {
        Played = played;
    }

    public String getGoals() {
        return Goals;
    }

    public void setGoals(String goals) {
        Goals = goals;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
    }
}
