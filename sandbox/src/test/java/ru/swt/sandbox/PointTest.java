package ru.swt.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTest {

	@Test
	public void testDistanceBetweenPointsWithSimilarCoordinates() {
		Point p1 = new Point(10, 10);
		Point p2 = new Point(10, 10);
		Assert.assertEquals(0.0, p1.distance(p2), 0);
	}

	@Test
	public void testDistanceBetweenPointsWithPositivesCoordinates(){
		Point p1 = new Point(0, 0);
		Point p2 = new Point(100, 0);
		Assert.assertEquals(100.0, p1.distance(p2), 0);
	}

	@Test
	public void testDistanceBetweenPointsWithNegativeCoordinates(){
		Point p1 = new Point(0, 0);
		Point p2 = new Point(0, -100);
		Assert.assertEquals(100.0, p1.distance(p2), 0);
	}
}
