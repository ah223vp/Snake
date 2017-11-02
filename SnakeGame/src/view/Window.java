package view;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.SnakeGame;

public class Window extends Application{

    final int WIDTH = 1000;
    final int HEIGHT = 1000;
    SnakeGame snakeGame;
    private Painter paint;
    private GraphicsContext context;
    private KeyActions ka;



    public void start(Stage primaryStage){

        // This sucks....
        this.snakeGame = new SnakeGame();

        Canvas canvas = new Canvas(WIDTH,HEIGHT);
        this.context = canvas.getGraphicsContext2D();

        this.paint = new Painter(this.snakeGame, this.context);
        StackPane root = new StackPane();
        ka = new KeyActions();
        ka.keyPressedActions(canvas, this.snakeGame);

        root.getChildren().addAll(canvas);

        Scene scene = new Scene(root, WIDTH,HEIGHT);

        primaryStage.setScene(scene);
        primaryStage.show();


    }


}
