package view;

import javafx.scene.canvas.Canvas;
import model.SnakeGame;


public class KeyActions {


    public void keyPressedActions(Canvas canvas, SnakeGame snakeGame){

        canvas.setFocusTraversable(true);
        canvas.setOnKeyPressed(e -> {

            switch (e.getCode()){
                case UP:
                    snakeGame.getSnake().setMoveUP();
                    break;
                case DOWN:
                    snakeGame.getSnake().setMoveDown();
                    break;
                case LEFT:
                    snakeGame.getSnake().setMoveLeft();
                    break;
                case RIGHT:
                    snakeGame.getSnake().setMoveRight();
                    break;
                case SPACE:
                    System.out.println(snakeGame);
                    snakeGame.start();
            }
        });

    }

}
