package com.fdc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.pojo.Collections;

/**
 * A data access object (DAO) providing persistence and search support for
 * Collections entities. Transaction control of the save(), update() and
 * delete() operations can directly support Spring container-managed
 * transactions or they can be augmented to handle user-managed Spring
 * transactions. Each of these methods provides additional information for how
 * to configure it for the desired type of transaction control.
 * 
 * @see com.fdc.pojo.Collections
 * @author MyEclipse Persistence Tools
 */
public class CollectionsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(CollectionsDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String HOUSE_NEWS_ID = "houseNewsId";

	protected void initDao() {
		// do nothing
	}

	public void save(Collections transientInstance) {
		log.debug("saving Collections instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Collections persistentInstance) {
		log.debug("deleting Collections instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Collections findById(java.lang.Integer id) {
		log.debug("getting Collections instance with id: " + id);
		try {
			Collections instance = (Collections) getHibernateTemplate().get(
					"com.fdc.pojo.Collections", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Collections instance) {
		log.debug("finding Collections instance by example");
		try {
			List results = getHibernateTemplate().findByExample(instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	public List findByProperty(String propertyName, Object value) {
		log.debug("finding Collections instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Collections as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List findByHouseNewsId(Object houseNewsId) {
		return findByProperty(HOUSE_NEWS_ID, houseNewsId);
	}

	public List findAll() {
		log.debug("finding all Collections instances");
		try {
			String queryString = "from Collections";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Collections merge(Collections detachedInstance) {
		log.debug("merging Collections instance");
		try {
			Collections result = (Collections) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Collections instance) {
		log.debug("attaching dirty Collections instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Collections instance) {
		log.debug("attaching clean Collections instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static CollectionsDAO getFromApplicationContext(
			ApplicationContext ctx) {
		return (CollectionsDAO) ctx.getBean("CollectionsDAO");
	}
}