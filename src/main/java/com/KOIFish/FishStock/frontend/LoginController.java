package com.KOIFish.FishStock.frontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

@Controller
public class LoginController {
	
	private FishStockBusinessDelegate delegate;
	@Autowired
	public void setDelegate(FishStockBusinessDelegate delegate) { this.delegate = delegate; }

	@ResponseBody
	@RequestMapping(value={"/login.do"}, method={RequestMethod.POST}, consumes={"application/json"}, produces={"application/json"})
	public String login(@RequestBody FishStockUser user, HttpSession session) {
		
		user = delegate.authenticateUser(user.getUsername(), user.getPassword());
		
		session.setAttribute("user_obj", user);
		
		if (user == null) {
			return "{ \"result\" : \"failure\" }";
		}		
		
		return "{ \"result\" : \"success\" }";
	}
	
	@ResponseBody
	@RequestMapping(value={"/getuser.do"}, method={RequestMethod.GET}, produces={"application/json"})
	public FishStockUser getUser(HttpSession session) {
		
		session.getAttribute("user_obj").getClass();
		
		return (FishStockUser)session.getAttribute("user_obj"); 
	}
	
	@RequestMapping(value={"/logout.do"}, method={RequestMethod.GET})
	public void logout(HttpSession session) {
		
		session.setAttribute("user_obj", null);
	}
	
}
