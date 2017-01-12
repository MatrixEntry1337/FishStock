package com.KOIFish.FishStock.frontend;

import java.util.Set;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockTimePeriod;
import com.KOIFish.FishStock.beans.FishStockUser;
import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;

@Controller
public class TimePeriodController {

	private FishStockBusinessDelegate delegate;
	@Autowired
	public void setDelegate( FishStockBusinessDelegate delegate){
		this.delegate = delegate;
	}
	
	@ResponseBody
	@RequestMapping(value={"/addToWatch.do"}, method={RequestMethod.POST}, consumes={"application/json"})
	public void addToWatch(@RequestBody FishStockCompany company, HttpSession session){
		
		// get user from session
		FishStockUser user = (FishStockUser)session.getAttribute("user_obj");
		
		// pass to delegate
		delegate.addCompanyToWatch(user, company);
	}
	
	@ResponseBody
	@RequestMapping(value={"/removeFromWatch.do"}, method={RequestMethod.POST}, consumes={"application/json"})
	public void removeFromWatch(@RequestBody FishStockCompany company, HttpSession session){
		
		// get user from session
		FishStockUser user = (FishStockUser)session.getAttribute("user_obj");
		
		// pass to delegate
		delegate.removeCompanyFromWatch(user, company);
	}
	
	@ResponseBody
	@RequestMapping(value={"/getAllWatchList.do"}, method={RequestMethod.GET}, produces={"application/json"})
	public Set<FishStockTimePeriod> getAllWatchList(){
		
		Set<FishStockTimePeriod> set = delegate.getAllWatchList();
		return set;
		
	}
	
	@ResponseBody
	@RequestMapping(value={"/getWatchList.do"}, method={RequestMethod.GET}, produces={"application/json"})
	public Set<FishStockTimePeriod> getWatchList(HttpSession session){
		
		FishStockUser user = (FishStockUser)session.getAttribute("user_obj");
		
		Set<FishStockTimePeriod> set = delegate.getWatchList(user);
		return set;
		
	}
	
}
