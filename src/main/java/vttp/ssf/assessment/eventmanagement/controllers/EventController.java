package vttp.ssf.assessment.eventmanagement.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.services.DatabaseService;

@Controller
@RequestMapping(path="/")
public class EventController {

	@Autowired
	DatabaseService dataSvc;

	//TODO: Task 5

	@GetMapping(path="/")
	public String displayEvents(Model model,HttpSession session) throws Exception{
		session.invalidate();
		List<Event> events = dataSvc.readFile();
		model.addAttribute("events", events);
		return "EventListing";
	}

}
