package com.fdc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.pojo.RecordRent;

/**
 * A data access object (DAO) providing persistence and search support for
 * RecordRent entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fdc.pojo.RecordRent
 * @author MyEclipse Persistence Tools
 */
public class RecordRentDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(RecordRentDAO.class);
	// property constants
	public static final String HOUSE_NEWS_ID = "houseNewsId";
	public static final String HOUSE_USER_ID = "houseUserId";
	public static final String RECORD_STATE = "recordState";
	public static final String RECORD_TYPE = "recordType";

	protected void initDao() {
		// do nothing
	}

	public void save(RecordRent transientInstance) {
		log.debug("saving RecordRent instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}
	
	public void update(RecordRent transientInstance) {
		log.debug("updating RecordRent instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}

	public void delete(RecordRent persistentInstance) {
		log.debug("deleting RecordRent instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public RecordRent findById(java.lang.Integer id) {
		log.debug("getting RecordRent instance with id: " + id);
		try {
			RecordRent instance = (RecordRent) getHibernateTemplate().get(
					"com.fdc.pojo.RecordRent", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RecordRent> findByExample(RecordRent instance) {
		log.debug("finding RecordRent instance by example");
		try {
			List<RecordRent> results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<RecordRent> findByProperty(String propertyName, Object value) {
		log.debug("finding RecordRent instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from RecordRent as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<RecordRent> findByHouseNewsId(Object houseNewsId) {
		return findByProperty(HOUSE_NEWS_ID, houseNewsId);
	}

	public List<RecordRent> findByHouseUserId(Object houseUserId) {
		return findByProperty(HOUSE_USER_ID, houseUserId);
	}

	public List<RecordRent> findByRecordState(Object recordState) {
		return findByProperty(RECORD_STATE, recordState);
	}

	public List<RecordRent> findByRecordType(Object recordType) {
		return findByProperty(RECORD_TYPE, recordType);
	}

	@SuppressWarnings("unchecked")
	public List<RecordRent> findAll() {
		log.debug("finding all RecordRent instances");
		try {
			String queryString = "from RecordRent";
			
			
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public RecordRent merge(RecordRent detachedInstance) {
		log.debug("merging RecordRent instance");
		try {
			RecordRent result = (RecordRent) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(RecordRent instance) {
		log.debug("attaching dirty RecordRent instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(RecordRent instance) {
		log.debug("attaching clean RecordRent instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static RecordRentDAO getFromApplicationContext(ApplicationContext ctx) {
		return (RecordRentDAO) ctx.getBean("RecordRentDAO");
	}
}