package com.example.dinorunstartmenu;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.View;
import android.view.WindowManager;

public class AppConstants {
    static BitmapBank bitmapBank;
    static GameEngine gameEngine;
    static int SCREEN_WIDTH, SCREEN_HEIGHT;
    static int gravity;
    static int VELOCITY_WHEN_JUMPED;
    static int VELOCITY_OBSTACLES;
    static Context gameActivityContext;
    static boolean playerGrounded;

    public static void initialization(Context context){
        setScreenSize(context);
        AppConstants.gameActivityContext = context;
        bitmapBank = new BitmapBank(context.getResources());
        setGameConstants();
        gameEngine = new GameEngine();
    }

    public static void setScreenSize(Context context){
        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        Display display = wm.getDefaultDisplay();
        DisplayMetrics metrics = new DisplayMetrics();
        display.getMetrics(metrics);
        int width = metrics.widthPixels;
        int height = metrics.heightPixels;
        AppConstants.SCREEN_WIDTH = width;
        AppConstants.SCREEN_HEIGHT = height;
    }

    public static void setGameConstants(){
        AppConstants.gravity = 3;
        AppConstants.VELOCITY_WHEN_JUMPED = -40;
        AppConstants.VELOCITY_OBSTACLES = 45;
        AppConstants.playerGrounded = true;
    }

    public static BitmapBank getBitmapBank() {
        return bitmapBank;
    }

    public static GameEngine getGameEngine(){
        return gameEngine;
    }


}
