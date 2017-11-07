package model;

import javafx.animation.AnimationTimer;

public class SnakeGame {

    private AnimationTimer loop;
    private int fps = 15;
    private Snake snake;


    public SnakeGame(){
        this.snake = new Snake();
    }

    public void start(){
        gameLoop();
        this.loop.start();
    }

    private void gameLoop(){

        loop = new AnimationTimer(){
            long lastUpdate = 0;

            @Override
            public void handle(long now) {
                // Framerate
                if(now - lastUpdate >= 1000_000_000){
                    snake.move();
                    System.out.println("Snake size is: " + snake.getBody().size());
                   
                    snake.drawFood();
                    lastUpdate = now;
                }

            }
        };
    }
    public void stopLoop(){
        this.loop.stop();
    }
    public Snake getSnake(){
        return this.snake;
    }

}
