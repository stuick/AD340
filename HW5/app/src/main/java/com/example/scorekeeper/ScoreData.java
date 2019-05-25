package com.example.scorekeeper;


public class ScoreData {

    private String p1Name;
    private String p2Name;
    private int ko;
    private int p1Total=0;
    private int p2Total=0;
    private int p1PrevScore=0;
    private int p2PrevScore=0;

    public ScoreData(){
        p1Name="AHMED";
        p2Name="AICHA";
        ko=150;
    }

    public ScoreData(int ko){
        this.ko=ko;
    }

    public String getP1Name(){
        return p1Name;
    }

    public String getP2Name(){
        return p2Name;
    }

    public int getP1PrevScore() {
        return p1PrevScore;
    }

    public int getP1Total() {
        return p1Total;
    }

    public int getP2PrevScore() {
        return p2PrevScore;
    }

    public int getP2Total() {
        return p2Total;
    }

    public void setP2Total(int p2Total) {
        this.p2Total = p2Total;
    }

    public void setP2PrevScore(int p2PrevScore) {
        this.p2PrevScore = p2PrevScore;
    }

    public void setP1PrevScore(int p1PrevScore) {
        this.p1PrevScore = p1PrevScore;
    }

    public void setP1Total(int p1Total) {
        this.p1Total = p1Total;
    }


    public int getKo(){
        return ko;
    }

    public boolean setKo(int ko) {
        if(ko<150)
            return false;
        else
            this.ko = ko;
        return true;
    }

    public void setP1Name(String p1Name) {
        this.p1Name = p1Name;
    }

    public void setP2Name(String p2Name) {
        this.p2Name = p2Name;
    }
}
