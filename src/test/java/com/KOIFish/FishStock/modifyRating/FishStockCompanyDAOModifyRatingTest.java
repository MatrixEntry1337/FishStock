package com.KOIFish.FishStock.modifyRating;

import com.KOIFish.FishStock.backend.FishStockCompanyDAO;
import com.KOIFish.FishStock.backend.implementations.FishStockCompanyDAOImplementation;
import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.Rating;
import com.KOIFish.FishStock.configuration.FishStockGlobalConfiguration;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.junit.After;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import static junit.framework.TestCase.assertEquals;


public class FishStockCompanyDAOModifyRatingTest {
    private static ApplicationContext context;
    private static SessionFactory sf;
    private static Rating rating;
    private Session session;
    private Transaction transaction;

    @BeforeClass
    public static void preClass() {
        context = new AnnotationConfigApplicationContext(FishStockGlobalConfiguration.class);
        sf = new Configuration().configure().buildSessionFactory();
        rating  = new Rating();
        rating.setCompanyId(1);
        rating.setRating(5);
    }

    @Before
    public void setUp() throws Exception {
        session = sf.openSession();
        transaction = session.beginTransaction();

    }

    @After
    public void tearDown() throws Exception {
        transaction.commit();
        session.close();
    }

    @Test
    public void modifyRating() throws Exception {
        Criteria criteria  = session.createCriteria(FishStockCompany.class);
        FishStockCompanyDAO companyDAO = new FishStockCompanyDAOImplementation();
        FishStockCompany firstCompany =  companyDAO.getCompany(session, rating.getCompanyId());
        firstCompany.setTotalRating(firstCompany.getTotalRating() + rating.getRating());
        firstCompany.setTotalUsersRated(firstCompany.getTotalUsersRated() + 1);
        companyDAO.modifyRating(session, rating);
        criteria.add(Restrictions.eq("companyId", rating.getCompanyId()));
        FishStockCompany secondCompany = (FishStockCompany) criteria.uniqueResult();
        assertEquals(firstCompany, secondCompany);
    }
}