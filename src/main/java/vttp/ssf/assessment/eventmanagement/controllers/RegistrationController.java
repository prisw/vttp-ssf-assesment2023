package vttp.ssf.assessment.eventmanagement.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import jakarta.servlet.http.HttpSession;
import jakarta.validation.Valid;
import vttp.ssf.assessment.eventmanagement.models.Event;
import vttp.ssf.assessment.eventmanagement.models.Register;

@Controller
@RequestMapping
public class RegistrationController {
    

    // TODO: Task 6
    @GetMapping(path="/registerpage")
	public String getRegisterPage(@Valid Event event, BindingResult result,Model model, HttpSession session) {
		if(result.hasErrors()) {
			System.out.println("error in display events page");
			return "EventListing";
		}

		session.setAttribute("event", event);
		model.addAttribute("register",new Register());
		return "eventregister";
	}


    // TODO: Task 7

     @PostMapping(path="/successful")
    public String processRegistration(@Valid Register register,BindingResult result,HttpSession session,Model model) {


        if(result.hasErrors()){
            System.out.println("error in filling registration page");
            return "eventregister";
        }

        Event clickedEvent = (Event) session.getAttribute("event");
        Register filledRegister = (Register) session.getAttribute("register");
        model.addAttribute("event", clickedEvent);
        model.addAttribute("register", filledRegister);

        return "SuccessRegistration";
    }
}
