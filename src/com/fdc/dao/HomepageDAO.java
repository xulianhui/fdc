package com.fdc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.pojo.Homepage;

/**
 * A data access object (DAO) providing persistence and search support for
 * Homepage entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fdc.pojo.Homepage
 * @author MyEclipse Persistence Tools
 */
public class HomepageDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(HomepageDAO.class);
	// property constants
	public static final String DIVNAME = "divname";
	public static final String PICADD = "picadd";
	public static final String REMARKS = "remarks";

	protected void initDao() {
		// do nothing
	}

	public void save(Homepage transientInstance) {
		log.debug("saving Homepage instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Homepage persistentInstance) {
		log.debug("deleting Homepage instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Homepage findById(java.lang.Integer id) {
		log.debug("getting Homepage instance with id: " + id);
		try {
			Homepage instance = (Homepage) getHibernateTemplate().get(
					"com.fdc.pojo.Homepage", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Homepage instance) {
		log.debug("finding Homepage instance by example");
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
		log.debug("finding Homepage instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Homepage as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByDivname(Object divname) {
		return findByProperty(DIVNAME, divname);
	}

	public List findByPicadd(Object picadd) {
		return findByProperty(PICADD, picadd);
	}

	public List findByRemarks(Object remarks) {
		return findByProperty(REMARKS, remarks);
	}

	public List findAll() {
		log.debug("finding all Homepage instances");
		try {
			String queryString = "from Homepage";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Homepage merge(Homepage detachedInstance) {
		log.debug("merging Homepage instance");
		try {
			Homepage result = (Homepage) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Homepage instance) {
		log.debug("attaching dirty Homepage instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Homepage instance) {
		log.debug("attaching clean Homepage instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HomepageDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HomepageDAO) ctx.getBean("HomepageDAO");
	}
}