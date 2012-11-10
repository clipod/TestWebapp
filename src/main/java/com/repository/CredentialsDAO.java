package com.repository;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class CredentialsDAO {
	
	public static final Logger LOGGER = LoggerFactory.getLogger(CredentialsDAO.class);
	
	public Long saveCredentials(CredentialsEntity credentialsEntity) {
		Session session = null;
		Transaction transaction = null;
		Long id = null;
		try {
			LOGGER.info("Elements in entity before saving "+ credentialsEntity.getUserName()+" "+credentialsEntity.getPassword());
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			id = (Long) session.save(credentialsEntity);
		} catch (HibernateException e) {
			e.printStackTrace();
			transaction.rollback();
		} finally {
			transaction.commit();
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return id;
	}

	public CredentialsEntity getCredentials(String userName) {
		Session session = null;
		CredentialsEntity entity = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			String queryString = "FROM CredentialsEntity C WHERE C.userName = :userName";
			entity = (CredentialsEntity) session.createQuery(queryString).setString("userName", userName).uniqueResult();
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (session != null && session.isOpen()) {
				session.close();
			}
		}

		return entity;
	}

	public void deleteCredentials(String userName) {
		Session session = null;
		Transaction transaction = null;
		try {
			session = HibernateUtil.getSessionFactory().openSession();
			transaction = session.beginTransaction();
			CredentialsEntity entity = (CredentialsEntity) session.get(CredentialsEntity.class, userName);
			session.delete(entity);
			
		} catch (HibernateException e) {
			transaction.rollback();
		} finally {
			transaction.commit();
			if (session != null && session.isOpen()) {
				session.close();
			}
		}
	}
}
