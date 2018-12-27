package model.service;

import java.time.Instant;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import model.entities.Log;
import model.entities.User;

public class LogService {
	
	private Set<Log> log = new HashSet<>();

	public LogService() {
	}

	public Set<Log> getLog() {
		return log;
	}

	public void insertLog(String user, String date) {
		log.add(new Log(new User(user), Date.from(Instant.parse(date))));
	}
	
	public void removeLog(User user, Date date) {
		log.remove(new Log(user, date));
	}
}
