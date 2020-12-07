package com.arijeet.model;

public class Player {
    final String name;
    int gamesWon;
    int pointsWon;

    public Player(String name) {
        this.name = name;
        this.gamesWon = 0;
        this.pointsWon = 0;
    }

    public String getName() {
        return name;
    }

    public int getGamesWon() {
        return gamesWon;
    }

    private void setGamesWon(int gamesWon) {
        this.gamesWon = gamesWon;
    }

    public int getPointsWon() {
        return pointsWon;
    }

    private void setPointsWon(int pointsWon) {
        this.pointsWon = pointsWon;
    }

    public void addGameWon() {
        setGamesWon(getGamesWon()+1);
    }

    public void addPoint() {
        setPointsWon(getPointsWon()+1);
    }

    public void resetPoints() {
        setPointsWon(0);
    }
}
