/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.controllers;

import com.shifan.dailyactivitymanager.models.Activity;
import com.shifan.dailyactivitymanager.models.ActivityType;
import com.shifan.dailyactivitymanager.services.ActivityService;
import com.shifan.dailyactivitymanager.services.ActivityTypeService;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class ActivityController {
	
	private ActivityService activityService;
        private ActivityTypeService activityTypeService;
        
	
	@Autowired(required=true)
	@Qualifier(value = "activityService")
	public void setActivityService(ActivityService activityService){
		this.activityService = activityService;
	}
        
        @Autowired(required=true)
	@Qualifier(value = "activityTypeService")
	public void setActivityTypeService(ActivityTypeService activityTypeService){
		this.activityTypeService = activityTypeService;
	}
	
	@RequestMapping(value = "/activityList", method = RequestMethod.GET)
	public String listActivites(Model model) {
               
                String start ="2021-08-31";
                String end = "2021-09-02";
            
		model.addAttribute("activity", new Activity());
		model.addAttribute("listActivites", this.activityService.listActivites(start, end));
                model.addAttribute("listActivityTypes", this.activityTypeService.listActivityTypes());
                
		return "activityList";
	}
	
	//For add and update activity both
	@RequestMapping(value= "/activity/add", method = RequestMethod.POST)
	public String addActivity(@ModelAttribute("activity") Activity activity, BindingResult result){
		
                
   
		if(activity.getId() == 0){
                    
                        activity.setCreatedDate(getCurrentDateTime());
                        activity.setActivityLastUpdateDate(getCurrentDateTime());
                        
			this.activityService.addActivity(activity);
		}else{
			//existing activity, call update
                        //activity.setLastUpdateDate(activity.getCreatedDate());
                        activity.setActivityLastUpdateDate(getCurrentDateTime());
			this.activityService.updateActivity(activity);
		}
		
		return "redirect:/activityList";
		
	}
        
    @RequestMapping("/activity")
    public String activityAddForm(@ModelAttribute("activity") Activity activity, Model model){
    model.addAttribute("listActivityTypes", this.activityTypeService.listActivityTypes());    
    return "activity";
    }
	
    @RequestMapping("activity/remove/{id}")
    public String removeActivity(@PathVariable("id") int id){
		
        this.activityService.removeActivity(id);
        return "redirect:/activityList";
    }
 
    @RequestMapping("activity/edit/{id}")
    public String editActivity(@PathVariable("id") int id, Model model){
        
        model.addAttribute("activity", this.activityService.getActivityById(id));
        model.addAttribute("listActivityTypes", this.activityTypeService.listActivityTypes());
      
        return "activity";
    }
    
    private String getCurrentDateTime(){
        Date now = new Date( );
        SimpleDateFormat ft = new SimpleDateFormat ("yyyy.MM.dd hh:mm:ss ");
        return ft.format(now);
    }
	
}
