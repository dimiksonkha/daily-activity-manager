/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.dao;

import com.shifan.dailyactivitymanager.models.ActivityType;
import java.util.List;

/**
 *
 * @author dimiksonkha
 */
public interface ActivityTypeDAO {
        
        public void addActivityType(ActivityType activityType);
	public void updateActivityType(ActivityType activityType);
	public List<ActivityType> listActivityTypes();
	public ActivityType getActivityTypeById(int id);
	public void removeActivityType(int id);
    
}
