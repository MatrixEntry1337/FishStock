package com.KOIFish.FishStock.frontend;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

public class TimePeriodController {

	private FishStockBusinessDelegate delegate;
	@Autowired
	public void setDelegate( FishStockBusinessDelegate delegate){
		this.delegate = delegate;
	}
	
	@ResponseBody
	@RequestMapping(value={"/addToWatch"}, method={RequestMethod.POST}, consumes={"application/json"})
	public void addToWatch(@RequestBody FishStockCompany company, HttpSession session){
		
		// get user from session
		FishStockUser user = (FishStockUser)session.getAttribute("user_obj");
		
		// pass to delegate
		delegate.addCompanyToWatch(user, company);
	}
}
