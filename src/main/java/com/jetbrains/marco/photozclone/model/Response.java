package com.jetbrains.marco.photozclone.model;

public class Response {
    private String tossResult;
    private String Score;
    private String batOrBowl;
    private String ActualToss;
    private  boolean comWonTossFlag;
    private String computerChoiceVar;



    private int coumputerGuessVar;
    private  int currentTotalVar;
    private boolean matchOverVar;
    private  String matchResult=null;
    private int targetScoreVar;

    public int playerScore;
    public int computerScore;

    public int getTargetScoreVar() {
        return targetScoreVar;
    }

    public void setTargetScoreVar(int targetScoreVar) {
        this.targetScoreVar = targetScoreVar;
    }

    public boolean isMatchOverVar() {
        return matchOverVar;
    }

    public void setMatchOverVar(boolean matchOverVar) {
        this.matchOverVar = matchOverVar;
    }
    public int getCoumputerGuessVar() {
        return coumputerGuessVar;
    }

    public void setCoumputerGuessVar(int coumputerGuessVar) {
        this.coumputerGuessVar = coumputerGuessVar;
    }

    public int getCurrentTotalVar() {
        return currentTotalVar;
    }

    public void setCurrentTotalVar(int currentTotalVar) {
        this.currentTotalVar = currentTotalVar;
    }

    public String getMatchResult() {
        return matchResult;
    }

    public void setMatchResult(String matchResult) {
        this.matchResult = matchResult;
    }

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