package com.fdc.dao;

import java.sql.Timestamp;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.pojo.Mails;

/**
 * A data access object (DAO) providing persistence and search support for Mails
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.fdc.pojo.Mails
 * @author MyEclipse Persistence Tools
 */
public class MailsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(MailsDAO.class);
	// property constants
	public static final String USER_FROM_ID = "userFromId";
	public static final String USER_TO_ID = "userToId";
	public static final String TITLE = "title";
	public static final String MAIL_CONTENT = "mailContent";
	public static final String READ_FLAG = "readFlag";

	protected void initDao() {
		// do nothing
	}

	public void save(Mails transientInstance) {
		log.debug("saving Mails instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Mails persistentInstance) {
		log.debug("deleting Mails instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Mails findById(java.lang.Integer id) {
		log.debug("getting Mails instance with id: " + id);
		try {
			Mails instance = (Mails) getHibernateTemplate().get(
					"com.fdc.pojo.Mails", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Mails instance) {
		log.debug("finding Mails instance by example");
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
		log.debug("finding Mails instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Mails as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByUserFromId(Object userFromId) {
		return findByProperty(USER_FROM_ID, userFromId);
	}

	public List findByUserToId(Object userToId) {
		return findByProperty(USER_TO_ID, userToId);
	}

	public List findByTitle(Object title) {
		return findByProperty(TITLE, title);
	}

	public List findByMailContent(Object mailContent) {
		return findByProperty(MAIL_CONTENT, mailContent);
	}

	public List findByReadFlag(Object readFlag) {
		return findByProperty(READ_FLAG, readFlag);
	}

	public List findAll() {
		log.debug("finding all Mails instances");
		try {
			String queryString = "from Mails";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Mails merge(Mails detachedInstance) {
		log.debug("merging Mails instance");
		try {
			Mails result = (Mails) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Mails instance) {
		log.debug("attaching dirty Mails instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Mails instance) {
		log.debug("attaching clean Mails instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static MailsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (MailsDAO) ctx.getBean("MailsDAO");
	}

	public boolean savenew(Mails mail) {
		// TODO Auto-generated method stub
		log.debug("saving Mails instance");
		boolean state = false;
		try {
			getHibernateTemplate().save(mail);
			log.debug("save successful");
			state = true;
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return state;
	}
}