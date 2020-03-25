package com.example.midulsterfootballleague;

public class League {
    private String Position;
    private String Points;
    private String Played;
    private String Goals;
    private String teamName;

    public League(String Position, String Points, String Played, String Goals, String teamName) {
        this.Position = Position;
        this.Points = Points;
        this.Played = Played;
        this.Goals = Goals;
        this.teamName = teamName;
    }

    public String getPosition() { return Position; }

    public void setPosition() { this.Position = Position; }

    public String getPoints() { return Points; }

    public void setPoints() { this.Points = Points; }

    public String getPlayed() { return Played; }

    public void setPlayed() { this.Played = Played; }

    public String getGoals() { return Goals; }

    public void setGoals() { this.Goals = Goals; }

    public String getTeamName() { return teamName; }

    public void setTeamName() { this.teamName = teamName; }

    public  String toString(){
        return this.Position + "  " + teamName + "  " +  Points + "  " +  Goals + "  " +  Points;
    }
}
