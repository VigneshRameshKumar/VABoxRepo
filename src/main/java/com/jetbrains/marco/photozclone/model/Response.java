package com.jetbrains.marco.photozclone.model;

public class Response {
    private String tossResult;
    private String Score;
    private String batOrBowl;
    private String ActualToss;
    private  boolean comWonTossFlag;
    private String computerChoiceVar;

    public String getComputerChoiceVar() {
        return computerChoiceVar;
    }

    public void setComputerChoiceVar(String computerChoiceVar) {
        this.computerChoiceVar = computerChoiceVar;
    }

    public boolean isComWonTossFlag() {
        return comWonTossFlag;
    }

    public void setComWonTossFlag(boolean comWonTossFlag) {
        this.comWonTossFlag = comWonTossFlag;
    }
//  System.out.println(name+ " " +email)
    // getters and setters


    public String getActualToss() {
        return ActualToss;
    }

    public void setActualToss(String actualToss) {
        ActualToss = actualToss;
    }

    public String getbatOrBowl() {
        return batOrBowl;
    }

    public void setbatOrBowl(String batOrBowl) {
        this.batOrBowl = batOrBowl;
    }

    public String getTossResult() {
        return tossResult;
    }

    public void setTossResult(String tossResult) {
        this.tossResult = tossResult;
    }

    public String getScore() {
        return Score;
    }

    public void setScore(String email) {
        this.Score = email;
    }
}