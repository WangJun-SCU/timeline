package com.timeline.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/main")
public class MainController {
	
	@RequestMapping("/getprojectname")
	@ResponseBody 
	public String getProjectName2() {
		return "timeline";
	}
	
}
