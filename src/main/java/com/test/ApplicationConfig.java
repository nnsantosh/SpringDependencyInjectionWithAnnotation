package com.test;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationEvent;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.event.EventListener;

@Configuration
@ComponentScan(basePackages = "com.test")
@PropertySource("classpath:triangle.properties")
public class ApplicationConfig {

	@Value("${triangle.pointA.x}")
	private String pointAxVal;

	@Value("${triangle.pointA.y}")
	private String pointAyVal;

	@Value("${triangle.pointB.x}")
	private String pointBxVal;

	@Value("${triangle.pointB.y}")
	private String pointByVal;

	@Value("${triangle.pointC.x}")
	private String pointCxVal;

	@Value("${triangle.pointC.y}")
	private String pointCyVal;

	@Bean
	@Qualifier("pointA")
	public Point loadPointAValues() {
		return new Point(Integer.parseInt(pointAxVal), Integer.parseInt(pointAyVal));
	}

	@Bean
	@Qualifier("pointB")
	public Point loadPointBValues() {
		return new Point(Integer.parseInt(pointBxVal), Integer.parseInt(pointByVal));
	}

	@Bean
	@Qualifier("pointC")
	public Point loadPointCValues() {
		return new Point(Integer.parseInt(pointCxVal), Integer.parseInt(pointCyVal));
	}

	@EventListener(ApplicationEvent.class)
	public void doSomethingAfterStartup() {
		System.out.println("I have just started up");
	}

	public static void main(String[] args) {
		ApplicationContext ctx = new AnnotationConfigApplicationContext(ApplicationConfig.class);
		TriangleWithPoints myTriangleWithPoints = ctx.getBean(TriangleWithPoints.class);
		myTriangleWithPoints.draw();
		DrawingApplication drawingApplication = ctx.getBean(DrawingApplication.class);
		drawingApplication.printPropertyName();
		drawingApplication.drawTriangle();

	}

}
