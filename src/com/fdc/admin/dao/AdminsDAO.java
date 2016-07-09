package com.fdc.admin.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.admin.pojo.Admins;

/**
 * A data access object (DAO) providing persistence and search support for
 * Admins entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fdc.admin.pojo.Admins
 * @author MyEclipse Persistence Tools
 */
public class AdminsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(AdminsDAO.class);
	// property constants
	public static final String USER_NAME = "userName";
	public static final String PASSWORD = "password";

	protected void initDao() {
		// do nothing
	}

	public void save(Admins transientInstance) {
		log.debug("saving Admins instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		}
		catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Admins persistentInstance) {
		log.debug("deleting Admins instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		}
		catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Admins findById(java.lang.Integer id) {
		log.debug("getting Admins instance with id: " + id);
		try {
			Admins instance = (Admins) getHibernateTemplate().get(
					"com.fdc.pojo.Admins", id);
			return instance;
		}
		catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Admins> findByExample(Admins instance) {
		log.debug("finding Admins instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Admins> results = getHibernateTemplate().findByExample(
					instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		}
		catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Admins> findByProperty(String propertyName, Object value) {
		log.debug("finding Admins instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Admins as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		}
		catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Admins> findByUserName(Object userName) {
		return findByProperty(USER_NAME, userName);
	}

	public List<Admins> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	@SuppressWarnings("unchecked")
	public List<Admins> findAll() {
		log.debug("finding all Admins instances");
		try {
			String queryString = "from Admins";
			return getHibernateTemplate().find(queryString);
		}
		catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Admins merge(Admins detachedInstance) {
		log.debug("merging Admins instance");
		try {
			Admins result = (Admins) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		}
		catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Admins instance) {
		log.debug("attaching dirty Admins instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		}
		catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Admins instance) {
		log.debug("attaching clean Admins instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		}
		catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static AdminsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (AdminsDAO) ctx.getBean("AdminsDAO");
	}
}