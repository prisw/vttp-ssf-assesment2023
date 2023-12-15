package vttp.ssf.assessment.eventmanagement.repositories;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;


import vttp.ssf.assessment.eventmanagement.models.Event;

@Repository
public class RedisRepository {

	@Autowired
	RedisTemplate<String,String> template;
	

	// TODO: Task 2
	public void saveRecord(Event event){
		template.opsForValue().set(event.getEventName(),event.toString());
	}

	// TODO: Task 3

	public Event getNumberofEvents(Event event){
		template.opsForList().size(event.getEventName());
		return event;
	}

	// TODO: Task 4
	public Event getEvent(Integer index) throws Exception {
		template.opsForValue().get(index);
		return getEvent(index);
	}
}
