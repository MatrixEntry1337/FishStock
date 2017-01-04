package com.KOIFish.FishStock.frontend;

import com.KOIFish.FishStock.middletier.FishStockBusinessDelegate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class RatingController {
    private FishStockBusinessDelegate delegate;
    @Autowired
    public void setDelegate(FishStockBusinessDelegate delegate) { this.delegate = delegate; }
    @ResponseBody
    @RequestMapping(value={"/addRating.do"}, method={RequestMethod.POST}, consumes={"application/json"}, produces={"application/json"})
    public void modifyCompanyRating(@RequestParam(value="rating") int rating, @RequestParam(value="companyId") int companyId) {
        delegate.modifyCompanyRating(rating, companyId);
    }
}
