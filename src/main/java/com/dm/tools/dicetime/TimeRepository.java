package com.dm.tools.dicetime;

import org.springframework.data.mongodb.repository.MongoRepository;

import com.dm.tools.dicetime.entity.Time;

public interface TimeRepository extends MongoRepository<Time, String> {
		
}
