package com.fdc.admin.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.admin.pojo.Users;

/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.fdc.admin.pojo.Users
 * @author MyEclipse Persistence Tools
 */
public class UsersDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(UsersDAO.class);
	// property constants
	public static final String NICK_NAME = "nickName";
	public static final String REAL_NAME = "realName";
	public static final String PASSWORD = "password";
	public static final String TEL = "tel";
	public static final String EMAIL = "email";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String IC_NUMBER = "icNumber";
	public static final String HEAD_IMG = "headImg";
	public static final String CHECKED = "checked";
	public static final String TYPE = "type";

	public void update(Users user) {
		try {
			getHibernateTemplate().update(user);
		}
		catch (RuntimeException exception) {
			log.error("update failed", exception);
			throw exception;
		}
	}

	protected void initDao() {
		// do nothing
	}

	public void save(Users transientInstance) {
		// log.debug("saving Users instance");
		try {
			getHibernateTemplate().save(transientInstance);
			// log.debug("save successful");
		}
		catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Users persistentInstance) {
		// log.debug("deleting Users instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			// log.debug("delete successful");
		}
		catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.Integer id) {
		// log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getHibernateTemplate().get(
					"com.fdc.admin.pojo.Users", id);
			return instance;
		}
		catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List<Users> findByExample(Users instance) {
		// log.debug("finding Users instance by example");
		try {
			@SuppressWarnings("unchecked")
			List<Users> results = getHibernateTemplate()
					.findByExample(instance);
			// log.debug("find by example successful, result size: "
			// + results.size());
			return results;
		}
		catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<Users> findByProperty(String propertyName, Object value) {
		// log.debug("finding Users instance with property: " + propertyName
		// + ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		}
		catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List<Users> findByNickName(Object nickName) {
		return findByProperty(NICK_NAME, nickName);
	}

	public List<Users> findByRealName(Object realName) {
		return findByProperty(REAL_NAME, realName);
	}

	public List<Users> findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List<Users> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<Users> findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List<Users> findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List<Users> findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List<Users> findByIcNumber(Object icNumber) {
		return findByProperty(IC_NUMBER, icNumber);
	}

	public List<Users> findByHeadImg(Object headImg) {
		return findByProperty(HEAD_IMG, headImg);
	}

	public List<Users> findByChecked(Object checked) {
		return findByProperty(CHECKED, checked);
	}

	public List<Users> findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	@SuppressWarnings("unchecked")
	public List<Users> findAll() {
		// log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			return getHibernateTemplate().find(queryString);
		}
		catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		// log.debug("merging Users instance");
		try {
			Users result = (Users) getHibernateTemplate().merge(
					detachedInstance);
			// log.debug("merge successful");
			return result;
		}
		catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Users instance) {
		// log.debug("attaching dirty Users instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			// log.debug("attach successful");
		}
		catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		// log.debug("attaching clean Users instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			// log.debug("attach successful");
		}
		catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UsersDAO) ctx.getBean("UsersDAO");
	}
}