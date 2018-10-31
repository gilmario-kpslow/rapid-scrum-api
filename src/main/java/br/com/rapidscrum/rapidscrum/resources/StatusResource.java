package br.com.rapidscrum.rapidscrum.resources;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/status")
public class StatusResource {
	
	@RequestMapping(method=RequestMethod.GET)
	public String hello() {
		return "Hello World!";
	}
}
