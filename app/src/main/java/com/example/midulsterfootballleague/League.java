package com.example.midulsterfootballleague;

public class League {
    String Position;
    String Points;
    String Played;
    String Goals;
    String teamName;

    public League() {
    }

    public League(String position, String points, String played, String goals, String teamName) {
        Position = position;
        Points = points;
        Played = played;
        Goals = goals;
        this.teamName = teamName;
    }

    public String getPosition() {
        return Position;
    }

    public void setPosition(String position) {
        Position = position;
    }

    public String getPoints() {
        return Points;
    }

    public void setPoints(String points) {
        Points = points;
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

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }
}
