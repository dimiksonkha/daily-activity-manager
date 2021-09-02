/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.dao;

import com.shifan.dailyactivitymanager.models.Activity;
import com.shifan.dailyactivitymanager.models.ActivityType;
import com.sun.org.apache.xerces.internal.impl.xpath.regex.Match;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 *
 * @author dimiksonkha
 */
public class ActivityDAOImpl implements ActivityDAO{
    private final static Logger logger = LoggerFactory.getLogger(ActivityDAOImpl.class);
    private SessionFactory sessionFactory;
    
    public void setSessionFactory(SessionFactory sf){
        this.sessionFactory = sf;
    }

    @Override
    public void addActivity(Activity activity) {
        Session session  = this.sessionFactory.getCurrentSession();
        session.persist(activity);
        logger.info("Activity saved successfully, Activity Details="+ activity);
    }

    @Override
    public void updateActivity(Activity activity) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(activity);
        logger.info("Activity updated successfully, Activity Details ="+ activity);
            }

    @Override
    public List<Activity> listActivites(String start, String end) {
        Session session = sessionFactory.getCurrentSession();
//       Criteria query = session.createCriteria(Activity.class);
//       query.add(Restrictions.like("createdDate","2021-09-02",MatchMode.START));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
       
        String startDate = start+" "+"00:00:00";
        String endDate = end+" "+"23:59:59";
        String hql = "from Activity where createdDate between :startDate and :endDate ";
        
        List<Activity> activityList = session.createQuery(hql)
             .setParameter("startDate", startDate)
             .setParameter("endDate", endDate)
             .list();
        for(Activity activity: activityList){
            logger.info("Activity List::"+activity);
        }
        
        return activityList;
    }

    @Override
    public Activity getActivityById(int id) {
        Session session  = sessionFactory.getCurrentSession();
        Activity activity = (Activity) session.load(Activity.class, new Integer(id));
        logger.info("Activity loaded successfully, Activity details="+activity);
        return activity;
            
    }

    @Override
    public void removeActivity(int id) {
        Session session  = sessionFactory.getCurrentSession();
        Activity activity = (Activity) session.load(Activity.class, new Integer(id));
        if (null != activity) {
          session.delete(activity);
        }
        
         logger.info("Activity deleted successfully, Activity details="+activity);
    }
    
}
