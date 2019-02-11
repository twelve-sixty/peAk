package com.twelvesixty.peak.model;

//This class would ideally be used for the message interface, but that is currently not available
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
