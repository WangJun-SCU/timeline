package com.timeline.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timeline.common.JsonResult;
import com.timeline.pojos.Catalog;
import com.timeline.services.CatalogService;

@Controller
@RequestMapping("/catalog")
public class CalalogController {
	
	JsonResult jsonResult = new JsonResult(0, "success");
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value = "/addcatalog", method=RequestMethod.POST)
	@ResponseBody
	public JsonResult addCatalog(@RequestBody Catalog catalog) {
		
		catalogService.addCatalog(catalog);
		jsonResult.setBody("目录插入成功");
		return jsonResult;
	}
}
