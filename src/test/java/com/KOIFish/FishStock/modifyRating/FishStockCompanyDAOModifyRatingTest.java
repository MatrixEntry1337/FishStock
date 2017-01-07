package com.KOIFish.FishStock.modifyRating;

import org.junit.BeforeClass;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.Rating;


public class FishStockCompanyDAOModifyRatingTest {
    private static ApplicationContext context;
    private static Rating rating;
    
    @BeforeClass
    public static void preClass() {
		context = new FileSystemXmlApplicationContext("src/main/webapp/WEB-INF/beans.xml");
        rating  = new Rating();
        rating.setCompanyId(1);
        rating.setRating(5);
    }

    @Test
    @Ignore
    // Hey Osher there is an easier way to do this. Once you feel better we can work through it together.
    public void modifyRating() throws Exception {
        FishStockCompanyDAO companyDAO = (FishStockCompanyDAO) context.getBean("companyDAO");
        FishStockCompany firstCompany =  companyDAO.getCompany(rating.getCompanyId());
        firstCompany.setTotalRating(firstCompany.getTotalRating() + rating.getRating());
        firstCompany.setTotalUsersRated(firstCompany.getTotalUsersRated() + 1);
        companyDAO.modifyRating(rating);
        
        //TODO change the below code (from Ilya)
        //since now we are using spring+hibernate through AOP, sessions and criteria
        //are only inside DAOs
        //also make sure that if you change data in db, revert it back to where it was
        
        /*
        criteria.add(Restrictions.eq("companyId", rating.getCompanyId()));
        FishStockCompany secondCompany = (FishStockCompany) criteria.uniqueResult();
        assertEquals(firstCompany, secondCompany);
        */
    }
}