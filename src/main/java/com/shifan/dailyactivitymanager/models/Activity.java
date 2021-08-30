/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.models;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author dimiksonkha
 */
@Entity
@Table(name="ACTIVITY")
public class Activity {
    
@Id
@Column(name="id")
@GeneratedValue(strategy=GenerationType.IDENTITY)
private int id;

private String   activityName;

@ManyToOne
@JoinColumn(name="activityTypeId")
private ActivityType activityType;

private String activityDescription;
private Double activityDuration;
private boolean isActive;

@Column(columnDefinition = "DATETIME")
private String createdDate;

   
@Column(columnDefinition = "DATETIME")
private String activityLastUpdateDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getActivityName() {
        return activityName;
    }

    public void setActivityName(String activityName) {
        this.activityName = activityName;
    }

    public ActivityType getActivityType() {
        return activityType;
    }

    public void setActivityType(ActivityType activityType) {
        this.activityType = activityType;
    }

    public String getActivityDescription() {
        return activityDescription;
    }

    public void setActivityDescription(String activityDescription) {
        this.activityDescription = activityDescription;
    }

   
    public Double getActivityDuration() {
        return activityDuration;
    }

    public void setActivityDuration(Double activityDuration) {
        this.activityDuration = activityDuration;
    }

    public boolean isIsActive() {
        return isActive;
    }

    public void setIsActive(boolean isActive) {
        this.isActive = isActive;
    }

    public String getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(String createdDate) {
        this.createdDate = createdDate;
    }

    public String getActivityLastUpdateDate() {
        return activityLastUpdateDate;
    }

    public void setActivityLastUpdateDate(String activityLastUpdateDate) {
        this.activityLastUpdateDate = activityLastUpdateDate;
    }



    
}
