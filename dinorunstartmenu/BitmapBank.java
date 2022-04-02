package com.example.dinorunstartmenu;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class BitmapBank {
    Bitmap cactus;
    Bitmap player;
    Bitmap path;
    public BitmapBank(Resources res) {
        cactus = BitmapFactory.decodeResource(res, R.drawable.cactus);
        player = BitmapFactory.decodeResource(res, R.drawable.dino);
        path = BitmapFactory.decodeResource(res, R.drawable.path);
    }

    public Bitmap getPath(){
        return path;
    }

    public int getPathWidth(){
        return path.getWidth();
    }

    public int getPathHeight(){
        return path.getHeight();
    }

    public Bitmap getPlayer() {
        return player;
    }
    public int getPlayerWidth(){
        return player.getWidth();
    }

    public int getPlayerHeight(){
        return player.getHeight();
    }

    public Bitmap getCactus() {
        return cactus;
    }

    public int getCactusWidth(){
        return cactus.getWidth();
    }

    public int getCactusHeight(){
        return cactus.getHeight();
    }

}
