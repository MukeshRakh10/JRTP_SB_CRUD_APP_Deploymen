package inst.mk.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class WelcomeController {

	@GetMapping("/")
	public String welcome() {
		return "Welcome To Full Stack Development";
	}
}
