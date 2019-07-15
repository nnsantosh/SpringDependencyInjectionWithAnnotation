package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class TriangleWithPoints {

	@Autowired
	@Qualifier("pointA")
	private Point pointA;
	@Autowired
	@Qualifier("pointB")
	private Point pointB;
	@Autowired
	@Qualifier("pointC")
	private Point pointC;

	@Override
	public String toString() {
		return "TriangleWithPoints [pointA=" + pointA + ", pointB=" + pointB + ", pointC=" + pointC + "]";
	}

	public void draw() {
		System.out.println("TriangleWithPoints.draw() A: " + this.pointA + " B: " + this.pointB + " C: " + this.pointC);
	}

}
