package model;

import java.util.Random;

import javafx.scene.paint.Color;

public class FoodFactory {

    // Handling Food here
	
	private Segment foodSegment;
	public FoodFactory(){
		foodSegment = new Segment(Color.BLUE);
	}

	public Segment setFood() {
		Random rand = new Random();
		int randomNum = rand.nextInt((20 - 0) + 0) * 50;
		double randomDouble = (double)randomNum;
		foodSegment.x = randomNum;
		int randomNum2 = rand.nextInt((20 - 0) + 0) * 50;
		double randomDouble2 = (double)randomNum2;
		foodSegment.y = randomNum2;
		return foodSegment;
	}
	
	public Segment getFood() {
		return foodSegment;
	}
	
	
	

}
