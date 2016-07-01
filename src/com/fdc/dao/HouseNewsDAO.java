package com.fdc.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.pojo.HouseNews;

/**
 * A data access object (DAO) providing persistence and search support for
 * HouseNews entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fdc.pojo.HouseNews
 * @author MyEclipse Persistence Tools
 */
public class HouseNewsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(HouseNewsDAO.class);
	// property constants
	public static final String HOUSE_ADDR = "houseAddr";
	public static final String HOUSE_FLOOR = "houseFloor";
	public static final String HOUSE_PRICE = "housePrice";
	public static final String HOUSE_TITLE = "houseTitle";
	public static final String HOUSE_AREA = "houseArea";
	public static final String HOUSE_STATUS = "houseStatus";
	public static final String TEL = "tel";
	public static final String NEWS_TYPE = "newsType";
	public static final String HOUSE_STRUCT = "houseStruct";
	public static final String HOUSE_LOOK = "houseLook";
	public static final String BUILDTYPE = "buildtype";
	public static final String BUILDTIME = "buildtime";
	public static final String VILLAGETYPE = "villagetype";
	public static final String SPECIAL = "special";
	public static final String PHOTO = "photo";

	protected void initDao() {
		// do nothing
	}

	public void save(HouseNews transientInstance) {
		log.debug("saving HouseNews instance");
		try {
			getHibernateTemplate().save(transientInstance);
			log.debug("save successful");
		} catch (RuntimeException re) {
			log.error("save failed", re);
			throw re;
		}
	}

	public void delete(HouseNews persistentInstance) {
		log.debug("deleting HouseNews instance");
		try {
			getHibernateTemplate().delete(persistentInstance);
			log.debug("delete successful");
		} catch (RuntimeException re) {
			log.error("delete failed", re);
			throw re;
		}
	}

	public HouseNews findById(java.lang.Integer id) {
		log.debug("getting HouseNews instance with id: " + id);
		try {
			HouseNews instance = (HouseNews) getHibernateTemplate().get(
					"com.fdc.pojo.HouseNews", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	public List findByExample(HouseNews instance) {
		log.debug("finding HouseNews instance by example");
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
		log.debug("finding HouseNews instance with property: " + propertyName
				+ ", value: " + value);
		try {
			String queryString = "from HouseNews as model where model."
					+ propertyName + "= ?";
			return getHibernateTemplate().find(queryString, value);
		} catch (RuntimeException re) {
			log.error("find by property name failed", re);
			throw re;
		}
	}

	public List findByHouseAddr(Object houseAddr) {
		return findByProperty(HOUSE_ADDR, houseAddr);
	}

	public List findByHouseFloor(Object houseFloor) {
		return findByProperty(HOUSE_FLOOR, houseFloor);
	}

	public List findByHousePrice(Object housePrice) {
		return findByProperty(HOUSE_PRICE, housePrice);
	}

	public List findByHouseTitle(Object houseTitle) {
		return findByProperty(HOUSE_TITLE, houseTitle);
	}

	public List findByHouseArea(Object houseArea) {
		return findByProperty(HOUSE_AREA, houseArea);
	}

	public List findByHouseStatus(Object houseStatus) {
		return findByProperty(HOUSE_STATUS, houseStatus);
	}

	public List findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List findByNewsType(Object newsType) {
		return findByProperty(NEWS_TYPE, newsType);
	}

	public List findByHouseStruct(Object houseStruct) {
		return findByProperty(HOUSE_STRUCT, houseStruct);
	}

	public List findByHouseLook(Object houseLook) {
		return findByProperty(HOUSE_LOOK, houseLook);
	}

	public List findByBuildtype(Object buildtype) {
		return findByProperty(BUILDTYPE, buildtype);
	}

	public List findByBuildtime(Object buildtime) {
		return findByProperty(BUILDTIME, buildtime);
	}

	public List findByVillagetype(Object villagetype) {
		return findByProperty(VILLAGETYPE, villagetype);
	}

	public List findBySpecial(Object special) {
		return findByProperty(SPECIAL, special);
	}

	public List findByPhoto(Object photo) {
		return findByProperty(PHOTO, photo);
	}

	public List findAll() {
		log.debug("finding all HouseNews instances");
		try {
			String queryString = "from HouseNews";
			return getHibernateTemplate().find(queryString);
		} catch (RuntimeException re) {
			log.error("find all failed", re);
			throw re;
		}
	}

	public HouseNews merge(HouseNews detachedInstance) {
		log.debug("merging HouseNews instance");
		try {
			HouseNews result = (HouseNews) getHibernateTemplate().merge(
					detachedInstance);
			log.debug("merge successful");
			return result;
		} catch (RuntimeException re) {
			log.error("merge failed", re);
			throw re;
		}
	}

	public void attachDirty(HouseNews instance) {
		log.debug("attaching dirty HouseNews instance");
		try {
			getHibernateTemplate().saveOrUpdate(instance);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public void attachClean(HouseNews instance) {
		log.debug("attaching clean HouseNews instance");
		try {
			getHibernateTemplate().lock(instance, LockMode.NONE);
			log.debug("attach successful");
		} catch (RuntimeException re) {
			log.error("attach failed", re);
			throw re;
		}
	}

	public static HouseNewsDAO getFromApplicationContext(ApplicationContext ctx) {
		return (HouseNewsDAO) ctx.getBean("HouseNewsDAO");
	}
}