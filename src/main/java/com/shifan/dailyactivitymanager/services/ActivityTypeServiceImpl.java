/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.services;

import com.shifan.dailyactivitymanager.dao.ActivityTypeDAO;
import com.shifan.dailyactivitymanager.models.ActivityType;
import java.util.List;
import javax.transaction.Transactional;

/**
 *
 * @author ayaan
 */
public class ActivityTypeServiceImpl implements ActivityTypeService{

    private ActivityTypeDAO activityTypeDAO;

	public void setActivityTypeDAO(ActivityTypeDAO activityTypeDAO) {
		this.activityTypeDAO = activityTypeDAO;
	}

	@Override
	@Transactional
	public void addActivityType(ActivityType activityType) {
		this.activityTypeDAO.addActivityType(activityType);
	}

	@Override
	@Transactional
	public void updateActivityType(ActivityType activityType) {
		this.activityTypeDAO.updateActivityType(activityType);
	}

	@Override
	@Transactional
	public List<ActivityType> listActivityTypes() {
		return this.activityTypeDAO.listActivityTypes();
	}

	@Override
	@Transactional
	public ActivityType getActivityTypeById(int id) {
		return this.activityTypeDAO.getActivityTypeById(id);
	}

	@Override
	@Transactional
	public void removeActivityType(int id) {
		this.activityTypeDAO.removeActivityType(id);
	}
    
}
