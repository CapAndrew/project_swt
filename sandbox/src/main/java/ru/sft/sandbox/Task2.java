package ru.sft.sandbox;

public class Task2 {

	public static void main(String[] args) {

		Point p1 = new Point(10,10);
		Point p2 = new Point(151,151);

		System.out.println("Distance is " + distance(p1,p2));
		System.out.println("Distance from method on class Point is " +p1.distance(p2));
	}


	private static double distance(Point p1, Point p2) {
		return Math.sqrt(Math.pow((p2.x - p1.x),2) + Math.pow((p2.y - p1.y),2));
	}
}
