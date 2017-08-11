package com.dm.tools.dicetime;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.dm.tools.dicetime.entity.Time;

@SpringBootApplication
public class DiceTimeApplication implements CommandLineRunner {

	@Autowired
	private TimeRepository repository;
	
	public static void main(String[] args) {
		SpringApplication.run(DiceTimeApplication.class, args);
	}
	
	@Override
	public void run(String... args) throws Exception {

		repository.deleteAll();

		// save a couple of customers
		repository.save(new Time("123"));

		// fetch all customers
		System.out.println("Looking up the sessions");
		System.out.println("-------------------------------");
		for (Time time : repository.findAll()) {
			System.out.println(time);
		}

	}
}
