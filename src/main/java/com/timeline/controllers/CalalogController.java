package com.timeline.controllers;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.timeline.common.JsonResult;
import com.timeline.common.RetCode;
import com.timeline.services.CatalogService;
import com.timeline.vo.CatalogVO;

@Controller
public class CalalogController {

	private static final Logger logger = LogManager.getLogger(CalalogController.class);

	@Autowired
	private CatalogService catalogService;

	@RequestMapping(value = "/catalogs", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult addCatalog(@RequestBody CatalogVO catalog) {
		logger.debug("req:" + catalog.toString());
		
		if(StringUtils.isEmpty(catalog.getLocation()) || catalog.getTime() == 0) {
			JsonResult jsonResult = new JsonResult(RetCode.ERROR_PARAM);
			return jsonResult;
		}

		JsonResult jsonResult = new JsonResult(RetCode.SUCCESS);
		catalogService.addCatalog(catalog);
		jsonResult.setBody("目录插入成功");

		return jsonResult;
	}

	@RequestMapping(value = "/catalogs", method = RequestMethod.GET)
	@ResponseBody
	public JsonResult queryCatalog() {
		// log4j2已经配置打印类型和方法名，因此这里只打印一个：Entry。
		logger.debug("Entry");
		
		List<CatalogVO> list = catalogService.queryCatalog();
		JsonResult jsonResult = new JsonResult(RetCode.SUCCESS);
		jsonResult.setBody(list);

		return jsonResult;
	}
}
