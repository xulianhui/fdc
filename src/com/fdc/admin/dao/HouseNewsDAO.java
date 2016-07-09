package com.fdc.admin.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.LockMode;
import org.springframework.context.ApplicationContext;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import com.fdc.admin.pojo.HouseNews;

/**
 * A data access object (DAO) providing persistence and search support for
 * HouseNews entities. Transaction control of the save(), update() and delete()
 * operations can directly support Spring container-managed transactions or they
 * can be augmented to handle user-managed Spring transactions. Each of these
 * methods provides additional information for how to configure it for the
 * desired type of transaction control.
 * 
 * @see com.fdc.admin.pojo.HouseNews
 * @author MyEclipse Persistence Tools
 */
public class HouseNewsDAO extends HibernateDaoSupport {
	private static final Log log = LogFactory.getLog(HouseNewsDAO.class);
	// property constants
	public static final String USER_ID = "userId";
	public static final String NEWS_TYPE = "newsType";
	public static final String HOUSE_REG = "houseReg";
	public static final String HOUSE_ADD_DETAIL = "houseAddDetail";
	public static final String HOUSE_TITLE = "houseTitle";
	public static final String HOUSE_FLOOR = "houseFloor";
	public static final String HOUSE_PRICE = "housePrice";
	public static final String HOUSE_HALL = "houseHall";
	public static final String HOUSE_WC = "houseWc";
	public static final String HOUSE_ROOM = "houseRoom";
	public static final String HOUSE_AREA = "houseArea";
	public static final String BUILD_TYPE = "buildType";
	public static final String HOUSE_DETAIL = "houseDetail";
	public static final String TEL = "tel";
	public static final String IMG1 = "img1";
	public static final String IMG2 = "img2";
	public static final String IMG3 = "img3";
	public static final String IMG4 = "img4";
	public static final String IMG5 = "img5";
	public static final String IMG6 = "img6";
	public static final String HOUSE_NEWS_STATUS = "houseNewsStatus";

	public void update(HouseNews houseNews) {
		getHibernateTemplate().update(houseNews);
	}

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
					"com.fdc.admin.pojo.HouseNews", id);
			return instance;
		} catch (RuntimeException re) {
			log.error("get failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<HouseNews> findByExample(HouseNews instance) {
		log.debug("finding HouseNews instance by example");
		try {
			List<HouseNews> results = getHibernateTemplate().findByExample(
					instance);
			log.debug("find by example successful, result size: "
					+ results.size());
			return results;
		} catch (RuntimeException re) {
			log.error("find by example failed", re);
			throw re;
		}
	}

	@SuppressWarnings("unchecked")
	public List<HouseNews> findByProperty(String propertyName, Object value) {
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

	public List<HouseNews> findByUserId(Object userId) {
		return findByProperty(USER_ID, userId);
	}

	public List<HouseNews> findByNewsType(Object newsType) {
		return findByProperty(NEWS_TYPE, newsType);
	}

	public List<HouseNews> findByHouseReg(Object houseReg) {
		return findByProperty(HOUSE_REG, houseReg);
	}

	public List<HouseNews> findByHouseAddDetail(Object houseAddDetail) {
		return findByProperty(HOUSE_ADD_DETAIL, houseAddDetail);
	}

	public List<HouseNews> findByHouseTitle(Object houseTitle) {
		return findByProperty(HOUSE_TITLE, houseTitle);
	}

	public List<HouseNews> findByHouseFloor(Object houseFloor) {
		return findByProperty(HOUSE_FLOOR, houseFloor);
	}

	public List<HouseNews> findByHousePrice(Object housePrice) {
		return findByProperty(HOUSE_PRICE, housePrice);
	}

	public List<HouseNews> findByHouseHall(Object houseHall) {
		return findByProperty(HOUSE_HALL, houseHall);
	}

	public List<HouseNews> findByHouseWc(Object houseWc) {
		return findByProperty(HOUSE_WC, houseWc);
	}

	public List<HouseNews> findByHouseRoom(Object houseRoom) {
		return findByProperty(HOUSE_ROOM, houseRoom);
	}

	public List<HouseNews> findByHouseArea(Object houseArea) {
		return findByProperty(HOUSE_AREA, houseArea);
	}

	public List<HouseNews> findByBuildType(Object buildType) {
		return findByProperty(BUILD_TYPE, buildType);
	}

	public List<HouseNews> findByHouseDetail(Object houseDetail) {
		return findByProperty(HOUSE_DETAIL, houseDetail);
	}

	public List<HouseNews> findByTel(Object tel) {
		return findByProperty(TEL, tel);
	}

	public List<HouseNews> findByImg1(Object img1) {
		return findByProperty(IMG1, img1);
	}

	public List<HouseNews> findByImg2(Object img2) {
		return findByProperty(IMG2, img2);
	}

	public List<HouseNews> findByImg3(Object img3) {
		return findByProperty(IMG3, img3);
	}

	public List<HouseNews> findByImg4(Object img4) {
		return findByProperty(IMG4, img4);
	}

	public List<HouseNews> findByImg5(Object img5) {
		return findByProperty(IMG5, img5);
	}

	public List<HouseNews> findByImg6(Object img6) {
		return findByProperty(IMG6, img6);
	}

	public List<HouseNews> findByHouseNewsStatus(Object houseNewsStatus) {
		return findByProperty(HOUSE_NEWS_STATUS, houseNewsStatus);
	}

	@SuppressWarnings("unchecked")
	public List<HouseNews> findAll() {
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