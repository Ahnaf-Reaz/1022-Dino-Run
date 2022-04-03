package com.example.dinorunstartmenu;

public class Path {
    private int pathX, pathY, pathVelocity;

    public Path(){
        pathX = 0;
        pathY = AppConstants.SCREEN_HEIGHT - AppConstants.getBitmapBank().getPathHeight();
        pathVelocity = 15;
    }

    public int getPathX() {
        return pathX;
    }

    public int getPathY() {
        return pathY;
    }

    public void setPathX(int pathX) {
        this.pathX = pathX;
    }

    public int getPathVelocity() {
        return pathVelocity;
    }
}
