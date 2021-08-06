/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.controllers;

import com.shifan.dailyactivitymanager.models.ActivityType;
import com.shifan.dailyactivitymanager.services.ActivityTypeService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author dimiksonkha
 */
@Controller
public class ActivityTypeController {
	
	private ActivityTypeService activityTypeService;
	
	@Autowired(required=true)
	@Qualifier(value = "activityTypeService")
	public void setActivityTypeService(ActivityTypeService activityTypeService){
		this.activityTypeService = activityTypeService;
	}
	
	@RequestMapping(value = "/activityTypes", method = RequestMethod.GET)
	public String listActivityTypes(Model model) {
		model.addAttribute("activityType", new ActivityType());
		model.addAttribute("listActivityTypes", this.activityTypeService.listActivityTypes());
		return "activityType";
	}
	
	//For add and update activityType both
	@RequestMapping(value= "/activityType/add", method = RequestMethod.POST)
	public String addActivityType(@ModelAttribute("activityType") ActivityType activityType ){
		
		if(activityType.getId() == 0){
			//new activityType, add it
			this.activityTypeService.addActivityType(activityType);
		}else{
			//existing activityType, call update
			this.activityTypeService.updateActivityType(activityType);
		}
		
		return "redirect:/activityTypes";
		
	}
	
	@RequestMapping("/remove/{id}")
    public String removeActivityType(@PathVariable("id") int id){
		
        this.activityTypeService.removeActivityType(id);
        return "redirect:/activityTypes";
    }
 
    @RequestMapping("/edit/{id}")
    public String editActivityType(@PathVariable("id") int id, Model model){
        model.addAttribute("activityType", this.activityTypeService.getActivityTypeById(id));
        model.addAttribute("listActivityTypes", this.activityTypeService.listActivityTypes());
        return "activityType";
    }
	
}
