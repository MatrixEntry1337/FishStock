package com.KOIFish.FishStock.modifyRating;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.Rating;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.FileSystemXmlApplicationContext;

import javax.persistence.RollbackException;

import static org.junit.Assert.assertEquals;


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

    @Test(expected = RollbackException.class)
    public void modifyRating() throws Exception {
        FishStockCompanyDAO companyDAO = (FishStockCompanyDAO) context.getBean("companyDAO");
        FishStockCompany firstCompany =  companyDAO.getCompany(rating.getCompanyId());
        firstCompany.setTotalRating(firstCompany.getTotalRating() + rating.getRating());
        firstCompany.setTotalUsersRated(firstCompany.getTotalUsersRated() + 1);
        companyDAO.modifyRating(rating);
        FishStockCompany secondCompany = companyDAO.getCompany(rating.getCompanyId());
        assertEquals(firstCompany, secondCompany);
        throw new RollbackException();
    }
}