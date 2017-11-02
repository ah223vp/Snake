package model;

import javafx.scene.paint.Color;

public class Segment {

    double x = 50;
    double y = 50;
    private Color color;

    public Segment(Color color){
        this.color = color;
    }
    public double getX(){
        return x;
    }
    public double getY(){
        return y;
    }
    public Color getColor(){
        return color;
    }

}
