package com.example.dinorunstartmenu;

import java.util.Random;

public class Obstacles {
    public int cX, cY;
    public String type;
    public int velocity;
    public int width;
    Random random;

    public  Obstacles(String type){
        this.type = type;
        cX = AppConstants.SCREEN_WIDTH + 1000;
        cY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight();
        random = new Random();
        if(type.equalsIgnoreCase("Cactus")){
            cY -= AppConstants.getBitmapBank().getCactusHeight();
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);
            width = AppConstants.getBitmapBank().getCactusWidth();
        }
    }

    public void reset(){
        cX = AppConstants.SCREEN_WIDTH + 300;
        if(type.equalsIgnoreCase("Cactus")){
            this.velocity = AppConstants.VELOCITY_OBSTACLES + 14 + random.nextInt(5);
        }
    }
}
