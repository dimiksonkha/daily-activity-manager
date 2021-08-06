/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.shifan.dailyactivitymanager.controllers;

import java.util.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author dimiksonkha
 */
 
@Controller
public class HomeController {
    String activityMessage = "Welcome to Daily Activity Manager!!!"; 

   
    @RequestMapping("/")
    public String showHomePage(Model model) {
      
        
        model.addAttribute("message", activityMessage); 
     
        return "index";
               
	}
    
    
}
