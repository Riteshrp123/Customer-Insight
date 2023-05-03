package com.xworkz.customerinsigt.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.NoResultException;
import javax.persistence.Query;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.xworkz.customerinsigt.entity.CustomerInsightEntity;

@Repository
public class CustomerInsightDaoImpl implements CustomerInsightDao {

	@Autowired
	private EntityManagerFactory emf;

	public CustomerInsightDaoImpl() {
		System.out.println("Create" + this.getClass().getSimpleName());
	}

	@Override
	public boolean save(CustomerInsightEntity entity) {
		System.out.println("running save method");

		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			em.persist(entity);
			em.getTransaction().commit();
			return true;
		} else {
			return false;
		}
	}

	@Override
	public CustomerInsightEntity findByEmail(String email) {
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			try {
				em.getTransaction().begin();
				Query query = em.createNamedQuery("findByEmail", CustomerInsightEntity.class);
				query.setParameter("em", email);
				CustomerInsightEntity entity = (CustomerInsightEntity) query.getSingleResult();
				System.out.println("from dao find by email");
				System.out.println(entity);
				return entity;

			} catch (NoResultException e) {
				System.out.println("error is handled");
			}
		}
		return null;
	}

	@Override
	public CustomerInsightEntity findByEmailAndPassword(String email, String password) {
		if (emf != null) {
			try {
				EntityManager em = emf.createEntityManager();
				em.getTransaction().begin();
				Query query = em.createNamedQuery("findByEmailAndPassword", CustomerInsightEntity.class);
				query.setParameter("em", email);
				query.setParameter("pass", password);
				CustomerInsightEntity entity = (CustomerInsightEntity) query.getSingleResult();
				return entity;

			} catch (Exception e) {
				System.out.println(e);
			}
		}
		return null;
	}

	@Override
	public boolean updateByWrongPasswordCount(String email, int wrongPasswordCount) {
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("updateByWrongPasswordCount");
			query.setParameter("em", email);
			query.setParameter("cou", wrongPasswordCount);
			query.executeUpdate();
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public boolean updateAccountStatusByEmail(String acc_status, String email) {
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("updateAccountStatusByEmail");
			query.setParameter("acc", acc_status);
			query.setParameter("em", email);
			query.executeUpdate();
			em.getTransaction().commit();
			return true;
		}
		return false;
	}
    
	@Override
	public boolean updateOtpByEmail(int otp, String email) {
		if (emf != null) {
			EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
			Query query = em.createNamedQuery("updateOtpByEmail");
			query.setParameter("otp",otp);
			query.setParameter("eml",email);
			query.executeUpdate();
			em.getTransaction().commit();
			return true;
		}
		return false;
	}

	@Override
	public int getOtpByEmail(String email) {
		if(emf!=null){
         int entity=0;
			EntityManager em = emf.createEntityManager();
			try {
			em.getTransaction().begin();
		    Query query = em.createNamedQuery("getOtpByEmail");
            query.setParameter("eml", email);
		     entity =  (int) query.getSingleResult();
		    
			return entity;
			
	}catch (NoResultException e) {
		System.out.println(e);
		em.getTransaction().commit();
		return entity;
	}
	}
		return 0;
		
}

	@Override
	public boolean updatePasswordByEmail(String email, String password) {
		if(emf!=null){
		int entity = 0;
		EntityManager em = emf.createEntityManager();
			em.getTransaction().begin();
		    Query query = em.createNamedQuery("updatePasswordByEmail");
		    query.setParameter("eml", email);
		    query.setParameter("pass", password);
		    query.executeUpdate();
		    em.getTransaction().commit();
		    return true;
		}
		
		return false;
	}
}