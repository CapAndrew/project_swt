package ru.sft.sandbox;

public class Point {

	int x;
	int y;

	public Point(int x, int y) {
		this.x = x;
		this.y = y;
	}

	public double distance(Point p) {
		return Math.sqrt(Math.pow((p.x - this.x),2) + Math.pow((p.y - this.y),2));
	}
}
