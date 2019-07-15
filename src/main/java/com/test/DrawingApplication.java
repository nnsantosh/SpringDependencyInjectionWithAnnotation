package com.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;


@Component
public class DrawingApplication {
	
	@Value("${application.name}")
	private String appName;
	
	@Autowired
	private TriangleWithPoints triangeWithPoints;
	
	public void printPropertyName() {
		System.out.println("Application name from property file is: "+appName);
		
	}
	
	public void drawTriangle() {
		System.out.println("DrawingApplication.DrawingApplication() : "+triangeWithPoints);
	}
	
	
	
}
