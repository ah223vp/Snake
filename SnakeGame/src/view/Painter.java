package view;

import javafx.scene.canvas.GraphicsContext;
import model.IObserver;
import model.Segment;
import model.Snake;
import model.SnakeGame;


public class Painter implements IObserver {

    private GraphicsContext context;
    private SnakeGame snakeGame;
    private Snake snake;

    public Painter(SnakeGame snakeGame, GraphicsContext context){
        this.context = context;
        this.snakeGame = snakeGame;
        this.snake = this.snakeGame.getSnake();
        this.snake.addSubscriber(this);
    }

    @Override
    public Segment drawFood() {
        return null;
    }

    @Override
    public void drawSnake() {
        this.context.clearRect(0,0,1000,1000);

        for(Segment s: this.snake.getBody()){
            this.context.setFill(s.getColor());
            this.context.fillRect(s.getX(),s.getY(),50,50);
            System.out.println(s.getX());
        }

    }
}
