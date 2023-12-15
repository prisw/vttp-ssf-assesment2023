package vttp.ssf.assessment.eventmanagement;


import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.redis.core.ListOperations;
import org.springframework.data.redis.core.RedisTemplate;

import vttp.ssf.assessment.eventmanagement.repositories.RedisRepository;


@SpringBootApplication
public class EventmanagementApplication implements CommandLineRunner{

	@Autowired
	RedisRepository redisRepo;

	@Autowired
	private RedisTemplate<String,String> template;



	public static void main(String[] args) {
		SpringApplication.run(EventmanagementApplication.class, args);
	}
	
	// TODO: Task 1

	@Override
	public void run(String...args) throws Exception {

		ListOperations<String, String> opsList = template.opsForList();
		if(template.hasKey("eventlist")) template.delete("eventlist");

		List<String> eventNames = new LinkedList<>();
		eventNames.add("Christmas Eve Party");
		eventNames.add("Round Singapore Cycling");
		eventNames.add("Intro to SCRATCH");
		eventNames.add("JB Shopping !");
		opsList.rightPushAll("eventlist", eventNames);

	}
}
