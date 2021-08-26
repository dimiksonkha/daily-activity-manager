/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.services;

import com.shifan.dailyactivitymanager.models.Activity;
import java.util.List;

/**
 *
 * @author dimiksonkha
 */
public interface ActivityService {
    
        public void addActivity(Activity activity);
	public void updateActivity(Activity activity);
	public List<Activity> listActivites();
	public Activity getActivityById(int id);
	public void removeActivity(int id);
    
}
