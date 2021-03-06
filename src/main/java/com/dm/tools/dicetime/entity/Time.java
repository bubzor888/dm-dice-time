package com.dm.tools.dicetime.entity;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import javax.persistence.Id;

@Entity
public class Time {

	@Id
	private String session;
	
	private int hours;
	
	@OneToOne(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	private Pool pool;
	
	public Time() {}
	
	public Time(String session) {
		this.session = session;
		this.pool = new Pool();
	}
	
	public void nextHour() {
		hours++;
	}
	
	@Override
	public String toString() {
		return String.format(
                "Time[session=%s, hours=%s, pool=%s]",
                session, hours, pool);
	}

	public String getSession() {
		return session;
	}

	public void setSession(String session) {
		this.session = session;
	}

	public int getHours() {
		return hours;
	}

	public void setHours(int hours) {
		this.hours = hours;
	}

	public Pool getPool() {
		return pool;
	}

	public void setPool(Pool pool) {
		this.pool = pool;
	}
}
