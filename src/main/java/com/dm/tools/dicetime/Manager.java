package com.dm.tools.dicetime;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.dm.tools.dicetime.entity.Dice;
import com.dm.tools.dicetime.entity.Time;


@Component
public class Manager {

	private static Logger LOG = LoggerFactory.getLogger(Manager.class);
	
	@Autowired
	private TimeRepository repository;
	
	public String getTime(String sessionId) {
		Time time = repository.findOne(sessionId);
		
		LOG.info("Reading {}", time);
		
		return time.getHours() + " hours have passed. Pool has " + time.getPool().totalDice() + " dice.";
	}
	
	public String timePasses(String sessionId, Dice dice) {
		Time time = repository.findOne(sessionId);
		
		time.getPool().addDice(dice);
		
		String message ="Time passes...\n(Pool has " + time.getPool().totalDice() + " dice)";
		if (time.getPool().isThreasholdMet() && time.getPool().targetHit()) {
			time.getPool().clear();
			time.nextHour();
			message = "Time moves to hour " + time.getHours();
		}
		
		LOG.info("Updating {}", time);
		repository.save(time);
		
		
		return message;
	}
	
	public String shortRest(String sessionId) {
		
		return "A quiet night...";
	}
}
