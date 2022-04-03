package com.example.dinorunstartmenu;

public class Background {
    private int bgx, bgy, bgvelocity;

    public Background(){
        bgx = 0;
        bgy = 0;
        bgvelocity = 3;
    }

    public int getBgx() {
        return bgx;
    }

    public int getBgy() {
        return bgy;
    }

    public void setBgx(int bgx) {
        this.bgx = bgx;
    }

    public void setBgy(int bgy) {
        this.bgy = bgy;
    }

    public int getBgvelocity() {
        return bgvelocity;
    }
}