package com.smartnet.jackpotandroidversion.jackpot.model;

import com.google.gson.Gson;

public class JackpotModel {

    private String jp1;
    private String jp2;
    private String jp3;
    private String jp4;
    private String jp5;
    private int win_amnt;
    private int win_gm = 0;
    private static JackpotModel instance;


    public static JackpotModel getInstance() {
        if (instance == null) {
            instance = new JackpotModel();
        }
        return instance;
    }

    public void initInstance(String jsonData) {
        instance = provideJackpotData(jsonData);

    }

    public JackpotModel provideJackpotData(String jsonData) {
        return new Gson().fromJson(jsonData, JackpotModel.class);
    }


    public int getWin_amnt() {
        return win_amnt;
    }

    public void setWin_amnt(int win_amnt) {
        this.win_amnt = win_amnt;
    }

    public int getWin_gm() {
        return win_gm;
    }

    public void setWin_gm(int win_gm) {
        this.win_gm = win_gm;
    }

    public String getJp1() {
        return jp1;
    }

    public void setJp1(String jp1) {
        this.jp1 = jp1;
    }

    public String getJp2() {
        return jp2;
    }

    public void setJp2(String jp2) {
        this.jp2 = jp2;
    }

    public String getJp3() {
        return jp3;
    }

    public void setJp3(String jp3) {
        this.jp3 = jp3;
    }

    public String getJp4() {
        return jp4;
    }

    public void setJp4(String jp4) {
        this.jp4 = jp4;
    }

    public String getJp5() {
        return jp5;
    }

    public void setJp5(String jp5) {
        this.jp5 = jp5;
    }
}
