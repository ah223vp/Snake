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
    public void setX(Double x) {
    	this.x = x;
    }
    public void setY(Double y) {
    	this.y = y;
    }
    public boolean equals(Segment s) {
    	if((s.x == this.x) && (s.y == this.y)) {
    		return true;
    	}
    	else {
    		return false;
    	}
    	
    }

}
