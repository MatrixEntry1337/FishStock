package com.KOIFish.FishStock.backend;

import com.KOIFish.FishStock.beans.FishStockCompany;
import com.KOIFish.FishStock.beans.FishStockUser;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Set;

/**
 * Facade class that redirects calls to DAOs while handling sessions and transactions.
 * 
 * @author Ilya Siarheyeu
 *
 */
@Component(value="facade")
public class FishStockFacade {
	private FishStockUserDAO userDAO;
	@Autowired
	public void setUserDAO(FishStockUserDAO userDAO) { this.userDAO = userDAO; }

	private FishStockCompanyDAO companyDAO;
	@Autowired
	public void setCompanyDAO(FishStockCompanyDAO companyDAO){ this.companyDAO = companyDAO; }

	private FishStockSessionGiver sessionGiver;
	@Autowired
	public void setSessionGiver(FishStockSessionGiver sessionGiver) { this.sessionGiver = sessionGiver; }

	public FishStockFacade() { super(); }

	public FishStockUser getUserByUsername(String username) {
		Session session = null; 
		Transaction tx = null;
		FishStockUser result = null;
		try {
			session = sessionGiver.getNewSession();
			tx = session.beginTransaction();
			result = userDAO.getUserByUsername(session, username);
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		finally{
			session.disconnect();
			session.close();
		}
		return result;
	}

	public FishStockUser getUserById(Integer id) {
		Session session = null; 
		Transaction tx = null;
		FishStockUser result = null;
		try {
			session = sessionGiver.getNewSession();
			tx = session.beginTransaction();
			result = userDAO.getUserById(session, id);
			tx.commit();
		}
		catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}
		}
		finally{
			session.disconnect();
			session.close();
		}
		return result;
	}

	public Set<FishStockCompany> getAllCompanies(){
		Session session = null;
		Transaction tx = null;
		Set<FishStockCompany> set = null;
		try{
			session = sessionGiver.getNewSession();
			tx = session.beginTransaction();
			set = companyDAO.getAllCompanies(session);
			tx.commit();
		}catch(RuntimeException e){
			if(tx != null){
				tx.rollback();
			}
		}finally{
			session.disconnect();
			session.close();
		}
		return set;
	}
	public void modifyCompanyRating(int rating, int companyId) {
		Session session = null;
		Transaction tx = null;
		try {
		    session = sessionGiver.getNewSession();
		    tx = session.beginTransaction();
		    companyDAO.modifyRating(session, rating, companyId);
		    tx.commit();
        }catch (RuntimeException e) {
		    if(tx != null) {
		        tx.rollback();
            }
        }finally {
		    if(session != null) {
                session.disconnect();
                session.close();
            }
        }
    }
}
