package com.fdc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.pojo.Users;

/**
 * A data access object (DAO) providing persistence and search support for Users
 * entities. Transaction control of the save(), update() and delete() operations
 * can directly support Spring container-managed transactions or they can be
 * augmented to handle user-managed Spring transactions. Each of these methods
 * provides additional information for how to configure it for the desired type
 * of transaction control.
 * 
 * @see com.fdc.pojo.Users
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
	public static final String CHECKED = "checked";
	public static final String TYPE = "type";
	public static final String SEX = "sex";
	public static final String AGE = "age";
	public static final String IC_NUMBER = "icNumber";
	public static final String HEAD_IMG = "headImg";

	protected void initDao() {
		// do nothing
	}

	public void save(Users transientInstance) {
		log.debug("saving Users instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(Users persistentInstance) {
		log.debug("deleting Users instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public Users findById(java.lang.Integer id) {
		log.debug("getting Users instance with id: " + id);
		try {
			Users instance = (Users) getHibernateTemplate().get(
					"com.fdc.pojo.Users", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(Users instance) {
		log.debug("finding Users instance by example");
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
		log.debug("finding Users instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from Users as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByNickName(Object nickName) {
		return findByProperty(NICK_NAME, nickName);
	}

	public List findByRealName(Object realName) {
		return findByProperty(REAL_NAME, realName);
	}

	public List findByPassword(Object password) {
		return findByProperty(PASSWORD, password);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByEmail(Object email) {
		return findByProperty(EMAIL, email);
	}

	public List findByChecked(Object checked) {
		return findByProperty(CHECKED, checked);
	}

	public List findByType(Object type) {
		return findByProperty(TYPE, type);
	}

	public List findBySex(Object sex) {
		return findByProperty(SEX, sex);
	}

	public List findByAge(Object age) {
		return findByProperty(AGE, age);
	}

	public List findByIcNumber(Object icNumber) {
		return findByProperty(IC_NUMBER, icNumber);
	}

	public List findByHeadImg(Object headImg) {
		return findByProperty(HEAD_IMG, headImg);
	}

	public List findAll() {
		log.debug("finding all Users instances");
		try {
			String queryString = "from Users";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public Users merge(Users detachedInstance) {
		log.debug("merging Users instance");
		try {
			Users result = (Users) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(Users instance) {
		log.debug("attaching dirty Users instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(Users instance) {
		log.debug("attaching clean Users instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static UsersDAO getFromApplicationContext(ApplicationContext ctx) {
		return (UsersDAO) ctx.getBean("UsersDAO");
	}
	
	public List findByEmailPwd(Users instance) {
		try {
			String queryString = "from Users as model where model.email=? and password=?";
			return getHibernateTemplate().find(queryString, instance.getEmail(),instance.getPassword());
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}
	
	public Users queryByemail(String email) {   //根据用户名查找  
        @SuppressWarnings("unchecked")  
        List<Users> list = this.getHibernateTemplate().  
                find("from Users where email = ?",email);  
        if(list.size() == 0){                           //判断查询集合是否为空  
            return null;  
        }else {  
            return list.get(0);                         //返回第一个用户  
        }  
    }  
	
	public String savenew(Users transientInstance) {
		log.debug("saving Users instance");
		String addstate;
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
			addstate="ok";
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
		return addstate;
	}
	
	public void update(Users transientInstance) {
		log.debug("updating Users instance");
		try {
			getHibernateTemplate().update(transientInstance);
			log.debug("update successful");
		} catch (RuntimeException re) {
			log.error("update failed", re);
			throw re;
		}
	}
}