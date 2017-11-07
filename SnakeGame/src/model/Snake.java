package model;

import javafx.scene.paint.Color;

import java.util.ArrayList;

public class Snake {

	private Segment head;
	private ArrayList<Segment> body = new ArrayList<>();
	private ArrayList<IObserver> subs = new ArrayList<>();

	private final int moveUnit = 50;
	private FoodFactory foodFactory = new FoodFactory();
	private Segment food;

	// Default movement right
	private double dirX = 1;
	private double dirY = 0;

	public Snake() {
		this.head = new Segment(Color.RED);
		this.body.add(head);
		food = foodFactory.setFood();

		/*
		 * this.body.add(new Segment(Color.ALICEBLUE)); this.body.add(new
		 * Segment(Color.BROWN)); this.body.add(new Segment(Color.GREEN));
		 */
	}

	public void addSubscriber(IObserver sub) {
		subs.add(sub);
	}

	public void move() {
		this.head.x += dirX * moveUnit;
		this.head.y += dirY * moveUnit;

		
		if (checkLocation()) {
//			this.head.x += dirX * moveUnit;
//			this.head.y += dirY * moveUnit;

		} else {
//			this.head.x += dirX * moveUnit;
//			this.head.y += dirY * moveUnit;

			Segment temp = null;
			Segment temp2 = null;
			// body.set(0, head);
			for (int i = body.size()-1; i > 0; i--) {

				temp = body.get(i - 1 );
				//body.get(i+1).x;
				
				//body.set(i, body.get(i-1));
				
				//Change the x and y values in the list on each entry
				// (previously all entries got replaced so every entry pointed to the same object)
				body.set(i, body.get(i)).x = temp.x;
				body.set(i, body.get(i)).y = temp.y;

			}
		}
		
		//body.set(0, head);
		notifySub();
	}

	public void drawFood() {
		subs.get(0).drawFood();

	}

	public void setMoveUP() {
		dirX = 0;
		dirY = -1;
	}

	public void setMoveDown() {
		dirX = 0;
		dirY = 1;
	}

	public void setMoveLeft() {
		dirX = -1;
		dirY = 0;
	}

	public void setMoveRight() {
		dirX = 1;
		dirY = 0;
	}

	public Segment getFood() {

		return food;
	}

	private void notifySub() {
		for (IObserver sub : subs) {
			sub.drawSnake();
		}
	}

	public ArrayList<Segment> getBody() {
		return body;
	}

	private Boolean checkLocation() {
		// Colision with self here aswell.

		if (head.getX() >= 1000) {
			head.x = 0;
		} else if (head.getX() <= 0) {
			head.x = 1000;
		} else if (head.getY() >= 1000) {
			head.y = 0;
		} else if (head.getY() <= 0) {
			head.y = 1000;
		}
		if (food.equals(head)) {
			System.out.println("NOM NOM Snek happy!");
			Segment bodySegment = new Segment(Color.YELLOW);
			bodySegment.setX(head.x);
			bodySegment.setY(head.y);
			body.add(1, bodySegment);
			this.head.x = bodySegment.getX();
			this.head.y = bodySegment.getY();
			// body.get(0).setX(head.x);
			// body.get(0).setY(head.y);
			// this.head = body.get(0);

			foodFactory.setFood();
			System.out.println("New food placed");
			return true;

		}
		;
		return false;
	}

}
