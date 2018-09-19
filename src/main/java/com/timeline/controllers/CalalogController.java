package com.timeline.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
	
	private static final Logger logger = LogManager.getLogger(CalalogController.class);
	
	@Autowired
	private CatalogService catalogService;
	
	@RequestMapping(value = "/addcatalog", method=RequestMethod.POST)
	@ResponseBody
	public JsonResult addCatalog(@RequestBody CatalogVO catalog) {
		
		logger.debug("controller-addCatalog-req:" + catalog.toString());
		
		JsonResult jsonResult = new JsonResult(0, "success");
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
	
	@RequestMapping("/querycatalog")
	@ResponseBody
	public JsonResult queryCatalog() {
		List<CatalogVO> list = catalogService.queryCatalog();
		JsonResult jsonResult = new JsonResult(0, "success");
		jsonResult.setBody(list);
		
		return jsonResult;
	}
}
