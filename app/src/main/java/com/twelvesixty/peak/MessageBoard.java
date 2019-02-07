package com.twelvesixty.peak;

public class MessageBoard {
    private Team team;

    public MessageBoard () {}

    public MessageBoard (Team team) {
        this.team = team;
    }

    ////////////////////// -- getters

    public Team getTeam () {
        return this.team;
    }

    ////////////////////// -- setters

    public void setTeam (Team team) {
        this.team = team;
    }
}
