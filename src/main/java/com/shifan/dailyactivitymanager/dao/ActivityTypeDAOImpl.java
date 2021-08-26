package com.shifan.dailyactivitymanager.dao;


import com.shifan.dailyactivitymanager.models.ActivityType;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;


/**
 *
 * @author dimiksonkha
 */
@Repository
public class ActivityTypeDAOImpl implements ActivityTypeDAO{
    private static final Logger logger = LoggerFactory.getLogger(ActivityTypeDAOImpl.class);
    private SessionFactory sessionFactory;
	
    public void setSessionFactory(SessionFactory sf){
		this.sessionFactory = sf;
    }

    @Override
    public void addActivityType(ActivityType activityType) {
        Session session = this.sessionFactory.getCurrentSession();
		session.persist(activityType);
		logger.info("ActivityType saved successfully, Activity Type Details="+activityType);
    }

    @Override
    public void updateActivityType(ActivityType activityType) {
        Session session = this.sessionFactory.getCurrentSession();
		session.update(activityType);
		logger.info("ActivityType updated successfully, Activity Type Details="+activityType);
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public List<ActivityType> listActivityTypes() {
        Session session = this.sessionFactory.getCurrentSession();
		List<ActivityType> activityTypeList = session.createQuery("from ActivityType").list();
		for(ActivityType activityType : activityTypeList){
			logger.info("ActivityType List::"+activityType);
		}
		return activityTypeList;
    }

    @Override
    public ActivityType getActivityTypeById(int id) {
        Session session = this.sessionFactory.getCurrentSession();		
		ActivityType activityType = (ActivityType) session.load(ActivityType.class, new Integer(id));
		logger.info("ActivityType loaded successfully, ActivityType details="+activityType);
		return activityType;
    }

    @Override
    public void removeActivityType(int id) {
        Session session = this.sessionFactory.getCurrentSession();
		ActivityType activityType = (ActivityType) session.load(ActivityType.class, new Integer(id));
		if(null != activityType){
			session.delete(activityType);
		}
		logger.info("ActivityType deleted successfully, ActivityType details="+activityType);
    }
    
}
