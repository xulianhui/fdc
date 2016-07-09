package com.fdc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.pojo.Wanted;

/**
 * A data access object (DAO) providing persistence and search support for
 * Wanted entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fdc.pojo.Wanted
 * @author MyEclipse Persistence Tools
 */
public class WantedDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(WantedDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String USER_TEL = "userTel";
	public static final String MAX_PRICE = "maxPrice";
	public static final String MIN_AREA = "minArea";
	public static final String MAX_AREA = "maxArea";
	public static final String WANTED_TYPE = "wantedType";
	public static final String DETAILS = "details";

	protected void initDao() {
		// do nothing
	}

	public void save(Wanted transientInstance) {
		log.debug("saving Wanted instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Wanted persistentInstance) {
		log.debug("deleting Wanted instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Wanted findById(java.lang.Integer id) {
		log.debug("getting Wanted instance with id: " + id);
		try {
			Wanted instance = (Wanted) getHibernateTemplate().get(
					"com.fdc.pojo.Wanted", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Wanted> findByExample(Wanted instance) {
		log.debug("finding Wanted instance by example");
		try {
			List<Wanted> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Wanted> findByProperty(String propertyName, Object value) {
		log.debug("finding Wanted instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Wanted as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Wanted> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<Wanted> findByUserTel(Object userTel) {
		return findByProperty(USER_TEL, userTel);
	}

	public List<Wanted> findByMaxPrice(Object maxPrice) {
		return findByProperty(MAX_PRICE, maxPrice);
	}

	public List<Wanted> findByMinArea(Object minArea) {
		return findByProperty(MIN_AREA, minArea);
	}

	public List<Wanted> findByMaxArea(Object maxArea) {
		return findByProperty(MAX_AREA, maxArea);
	}

	public List<Wanted> findByWantedType(Object wantedType) {
		return findByProperty(WANTED_TYPE, wantedType);
	}

	public List<Wanted> findByDetails(Object details) {
		return findByProperty(DETAILS, details);
	}

	@SuppressWarnings("unchecked")
	public List<Wanted> findAll() {
		log.debug("finding all Wanted instances");
		try {
			String queryString = "from Wanted";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Wanted merge(Wanted detachedInstance) {
		log.debug("merging Wanted instance");
		try {
			Wanted result = (Wanted) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Wanted instance) {
		log.debug("attaching dirty Wanted instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Wanted instance) {
		log.debug("attaching clean Wanted instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static WantedDAO getFromApplicationContext(ApplicationContext ctx) {
		return (WantedDAO) ctx.getBean("WantedDAO");
	}
}