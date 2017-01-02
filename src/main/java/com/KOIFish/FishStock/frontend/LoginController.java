package com.KOIFish.FishStock.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class LoginController {
	
	@ResponseBody
	@RequestMapping(value={"/index"}, method={RequestMethod.POST}, produces={"application/json"})
	public String login() {
		
		return null;
	}
	
}
