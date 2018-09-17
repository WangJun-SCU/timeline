package com.timeline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timeline.common.JsonResult;
import com.timeline.services.CatalogService;
import com.timeline.vo.CatalogVO;

@Controller
@RequestMapping("/catalog")
public class CalalogController {
	
	JsonResult jsonResult = new JsonResult(0, "success");
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value = "/addcatalog", method=RequestMethod.POST)
	@ResponseBody
	public JsonResult addCatalog(@RequestBody CatalogVO catalog) {
		
		System.out.println("controller-addCatalog-req：" + catalog.toString());
		
		try {
			catalogService.addCatalog(catalog);
			jsonResult.setBody("目录插入成功");
		}catch(Exception e){
			jsonResult.setCode(-1);
			jsonResult.setMessage(e.getMessage());
			return jsonResult;
		}
		
		return jsonResult;
	}
}
