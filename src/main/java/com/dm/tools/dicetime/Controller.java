package com.dm.tools.dicetime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

	@Autowired
	private Manager manager;
	
	@GetMapping("/time")
	public String getTime() {
		return manager.getTime();
	}
}
