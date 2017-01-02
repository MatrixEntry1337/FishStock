package com.KOIFish.FishStock.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@ResponseBody
	@RequestMapping(value={"/login.do"}, method={RequestMethod.POST}, consumes={"application/json"})
	public String login(@RequestBody String username, @RequestBody String password) {
		
		System.out.println("Got here.");
		
		System.out.println(username + "  " + password);
		
		return null;
	}
	
}
