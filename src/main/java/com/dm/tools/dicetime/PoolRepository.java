package com.dm.tools.dicetime;

import org.springframework.data.repository.CrudRepository;

import com.dm.tools.dicetime.entity.Time;

public interface PoolRepository extends CrudRepository<Time, Long> {

}
