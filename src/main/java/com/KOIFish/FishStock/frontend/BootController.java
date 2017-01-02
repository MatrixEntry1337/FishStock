package com.KOIFish.FishStock.frontend;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BootController {
	
	@RequestMapping(value={"/index"}, method=RequestMethod.GET)
	// no response body.. returned value goes to IRVR
	public String homePage(){
		// InternalResourceViewResolver will prepend the prefix
		///WEB-INF/pages/index.html
		// requestDispatcher.forward(req,resp)
		return "index"; 
	}
}
