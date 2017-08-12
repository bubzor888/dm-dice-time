package com.dm.tools.dicetime.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pool {

	private static final int POOL_THRESHOLD = 6;
	private static final int TARGET_NUMBER = 1;
		
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private long id;
	
	private int d4;
	private int d6;
	private int d8;
	
	public Pool() {
		clear();
	}
	
	public void addDice(Dice dice) {
		switch (dice) {
			case D4:
				d4++;
				break;
			case D6:
				d6++;
				break;
			case D8:
				d8++;
				break;
		}
	}
	
	public boolean isThreasholdMet() {
		return totalDice() >= POOL_THRESHOLD;
	}
	
	public void clear() {
		d4 = 0;
		d6 = 0;
		d8 = 0;
	}
	
	public boolean targetHit() {
		boolean targetHit = false;
		System.out.println("Rolling the pool...");
		for (int i=0; i<totalDice(); i++) {
			int n = -1;
			if (i < d4) {
				n = Dice.D4.roll();
			} else if (i < (d4 + d6)) {
				n = Dice.D6.roll();
			} else {
				n = Dice.D8.roll();
			}
			
			System.out.print(" " + n);
			if (n == TARGET_NUMBER) {
				targetHit = true;
				break;
			}
		}
		System.out.println("Target Hit: " + targetHit);
		
		return targetHit;
	}
	
	public int totalDice() {
		return d4 + d6 + d8;
	}
	
	@Override
	public String toString() {
		return String.format(
                "Pool[d4=%s, d6=%s, d8=%s]",
                d4, d6, d8);
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public int getD4() {
		return d4;
	}

	public void setD4(int d4) {
		this.d4 = d4;
	}

	public int getD6() {
		return d6;
	}

	public void setD6(int d6) {
		this.d6 = d6;
	}

	public int getD8() {
		return d8;
	}

	public void setD8(int d8) {
		this.d8 = d8;
	}
}
