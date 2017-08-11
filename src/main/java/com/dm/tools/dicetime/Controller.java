package com.dm.tools.dicetime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dm.tools.dicetime.entity.Dice;

@RestController
public class Controller {

	@Autowired
	private Manager manager;
	
	@GetMapping("/time")
	public String getTime() {
		return manager.getTime("123");
	}
	
	@GetMapping("/timePasses")
	public String addTime(@RequestParam(name="diceSize", defaultValue="6") String diceSides) {
		return manager.timePasses("123", Dice.fromSides(diceSides));
	}
	
	@GetMapping("/shortRest")
	public String shortRest() {
		return manager.shortRest("123");
	}
}
