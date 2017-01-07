package com.KOIFish.FishStock.frontend;

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
	public FishStockUser login(@RequestBody FishStockUser user) {
		
		user = delegate.authenticateUser(user.getUsername(), user.getPassword());
		
		return user;
	}
	
}
