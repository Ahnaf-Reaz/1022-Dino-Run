package com.example.dinorunstartmenu;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

import java.util.ArrayList;
import java.util.Random;

public class GameEngine {
    Path path;
    Player player;
    Random random;
    int score;
    Paint scorePaint;
    static int gameState;
    ArrayList<Obstacles> obstaclesList;
    Obstacles obstacles;
    Obstacles obstacles1;
    Bitmap obs;
    boolean obsSpawned;
    int points;
    final int TEXT_SIZE = 80;
    boolean collision = false;

    public GameEngine(){
        path = new Path();
        player = new Player();
        gameState = 0;
        obsSpawned = false;
        random = new Random();
        score = 0;
        scorePaint = new Paint();
        scorePaint.setColor(Color.BLACK);
        scorePaint.setTextSize(TEXT_SIZE);
        scorePaint.setTextAlign(Paint.Align.LEFT);
        obstaclesList = new ArrayList<>();
        obstacles = new Obstacles("");
        obstacles1 = new  Obstacles("Cactus");
        obstaclesList.add(obstacles1);
        points = 0;
    }

    public void updateAndDrawPath(Canvas canvas){
        if(collision == false){
            path.setPathX(path.getPathX() - path.getPathVelocity());
            if(path.getPathX() < -AppConstants.getBitmapBank().getPathWidth()){
                path.setPathX(0);
            }
        }
        canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX(), path.getPathY(), null);
        if(path.getPathX() < - (AppConstants.getBitmapBank().getPathWidth() - AppConstants.SCREEN_WIDTH));{
            canvas.drawBitmap(AppConstants.getBitmapBank().getPath(), path.getPathX() +
                    AppConstants.getBitmapBank().getPathWidth(), path.getPathY(), null);
        }
    }

    public void updateAndDrawPlayer(Canvas canvas){
        if(gameState == 1){
            if(!collision && !AppConstants.playerGrounded){
                player.setVelocity(player.getVelocity() + AppConstants.gravity);
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayer(), player.getX(), player.getY(), null);

                if(player.getY() >= player.pYInitial) {
                    player.setY(player.pYInitial);
                    AppConstants.playerGrounded = true;
                }
            }else if(collision && !AppConstants.playerGrounded){
                player.setVelocity(player.getVelocity() + AppConstants.gravity);
                player.setY(player.getY() + player.getVelocity());
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayer(), player.getX(), player.getY(), null);
                gameState = 2;
                Context context = AppConstants.gameActivityContext;
             //   Intent intent = new Intent(context, GameOver.class);
           //     intent.putExtra("points", points);
             //   context.startActivity(intent);
                ((Activity) context).finish();
                if(player.getY() >= player.pYInitial) {
                    player.setY(player.pYInitial);
                    AppConstants.playerGrounded = true;
                }
            }else if(!collision && AppConstants.playerGrounded){
                canvas.drawBitmap(AppConstants.getBitmapBank().getPlayer(), player.getX(), player.getY(), null);
                gameState = 2;
                Context context = AppConstants.gameActivityContext;
             //   Intent intent = new Intent(context, GameOver.class);
             //   intent.putExtra("points", points);
            //    context.startActivity(intent);
                ((Activity) context).finish();
            }
            if(obstacles.cX <= player.pX + AppConstants.getBitmapBank().getPlayerWidth()
            && obstacles.cX + obstacles.width >= player.pX
            && obstacles.cY >= player.pY
            && obstacles.cY <= player.pY + AppConstants.getBitmapBank().getPlayerHeight()){
                collision = true;
                obstacles.reset();
            }
            canvas.drawText("Points: " + points, 0, TEXT_SIZE, scorePaint);
        }
    }

    public void  updateAndDrawObstacles(Canvas canvas){
        if(gameState == 1){
            if(obsSpawned == false){
                obstacles = obstaclesList.get(0);
                obsSpawned = true;
            }
            if (collision == false){
                obstacles.cX -= obstacles.velocity;
                if(obstacles.type.equalsIgnoreCase("Cactus")){
                    obs = AppConstants.getBitmapBank().getCactus();
                }
                canvas.drawBitmap(obs, obstacles.cX, obstacles.cY, null);
                if(obstacles.cX <= -AppConstants.getBitmapBank().getCactusWidth()){
                    obstacles.reset();
                    points++;
                    obsSpawned = false;
                }
            }
        }
    }
}
