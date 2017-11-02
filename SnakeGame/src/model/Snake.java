package model;


import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake {

    private Segment head;
    private ArrayList<Segment> body = new ArrayList<>();

    private ArrayList<IObserver> subs = new ArrayList<>();

    private final int moveUnit = 50;

    // Default movement right
    private double dirX = 1;
    private double dirY = 0;

    public Snake(){
        this.head = new Segment(Color.RED);
        this.body.add(head);
    }
    public void addSubscriber(IObserver sub){
        subs.add(sub);
    }
    public void move(){
        this.head.x += dirX * moveUnit;
        this.head.y += dirY * moveUnit;
        checkLocation();

        notifySub();
    }
    public void setMoveUP(){
        dirX = 0;
        dirY = 1;
    }
    public void setMoveDown(){
        dirX = 0;
        dirY = -1;
    }
    public void setMoveLeft(){
        dirX = -1;
        dirY = 0;
    }
    public void setMoveRight(){
        dirX = 1;
        dirY = 0;
    }
    private void notifySub(){
        for(IObserver sub : subs){
            sub.drawSnake();
        }
    }
    public ArrayList<Segment> getBody(){
        return body;
    }

    private void checkLocation(){
        // Colision with self here aswell.



        if(head.getX() >= 1000){
            head.x = 0;
        }else if(head.getX() <= 0){
            head.x = 1000;
        }else if(head.getY() >= 1000){
            head.y = 0;
        }else if(head.getY() <= 0){
            head.y = 1000;
        }
    }

}
