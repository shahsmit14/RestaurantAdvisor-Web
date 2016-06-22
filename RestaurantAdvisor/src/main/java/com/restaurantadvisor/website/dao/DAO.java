package com.restaurantadvisor.website.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;

public abstract class DAO {

	public Session getSession() {

		return HibernateUtilDAO.getSessionFactory().openSession();
	}

	protected DAO() {

	}

	protected void begin() {
		getSession().beginTransaction();
	}

	protected void commit() {
		getSession().getTransaction().commit();
	}

	protected void rollback() {

		try {
			getSession().getTransaction().rollback();
		} catch (HibernateException exe) {

		}

		try {
			getSession().close();
		} catch (HibernateException exe) {

		}
	}

	public void close() {
		getSession().close();
	}
}
