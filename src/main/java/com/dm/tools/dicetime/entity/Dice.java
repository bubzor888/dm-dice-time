package com.dm.tools.dicetime.entity;

import java.util.Random;

public enum Dice {
	D4(4), D6(6), D8(8); 
	
	private static final Random rand = new Random(); 
	
	private int sides;
	
	private Dice(int sides) {
		this.sides = sides;
	}
	
	public int getSides() {
		return sides;
	}
	
	public int roll() {
		return rand.nextInt(sides) + 1;
	}
	
	public static Dice fromSides(String sides) {
		for (Dice dice : Dice.values()) {
			if (Integer.toString(dice.getSides()).equals(sides)) {
				return dice;
			}
		}
		
		return D6;
	}
}
