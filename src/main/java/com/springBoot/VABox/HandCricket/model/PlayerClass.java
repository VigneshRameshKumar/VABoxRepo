package com.springBoot.VABox.HandCricket.model;

public class PlayerClass {
    private String batting;
    private  int score=0;
    public String name;

    public PlayerClass(String name){
        this.name=name;
    }
    public String getBatting() {
        return batting;
    }

    public void setBatting(String batting) {
        this.batting = batting;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

}
