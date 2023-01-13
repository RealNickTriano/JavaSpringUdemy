package com.in28minutes.spring.learnspringframework.game;

import org.springframework.stereotype.Component;

public class PacManGame implements GamingConsole{

	public void up() {
		System.out.println("PacMan up");
	}
	
	public void down() {
		System.out.println("PacMan down");
	}
	
	public void left() {
		System.out.println("PacMan left");
	}
	
	public void right() {
		System.out.println("PacMan right");
	}
}
