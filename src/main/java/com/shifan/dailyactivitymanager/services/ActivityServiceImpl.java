/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.services;

import com.shifan.dailyactivitymanager.dao.ActivityDAO;
import com.shifan.dailyactivitymanager.models.Activity;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author dimiksonkha
 */
public class ActivityServiceImpl implements ActivityService{

    private ActivityDAO activityDAO;
    
    public void setActivityDAO(ActivityDAO activityDAO){
        this.activityDAO = activityDAO;
    }

    @Transactional 
    @Override
    public void addActivity(Activity activity) {
        this.activityDAO.addActivity(activity);
        
    }

    @Transactional 
    @Override
    public void updateActivity(Activity activity) {
       this.activityDAO.updateActivity(activity);
    }
    @Transactional 
    @Override
    public List<Activity> listActivites() {
        return this.activityDAO.listActivites();
         
    }

    @Transactional
    @Override
    public Activity getActivityById(int id) {
       return this.activityDAO.getActivityById(id);
    }
    
    @Transactional
    @Override
    public void removeActivity(int id) {
        this.activityDAO.removeActivity(id);
    }

	

	
    
}
