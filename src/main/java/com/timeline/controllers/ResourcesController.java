package com.timeline.controllers;

import java.io.File;
import java.io.IOException;
import java.sql.Timestamp;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import com.timeline.common.Configuration;
import com.timeline.common.JsonResult;
import com.timeline.common.RetCode;
import com.timeline.common.Utils;
import com.timeline.entity.Resources;
import com.timeline.services.ResourcesService;

@Controller
public class ResourcesController {

	private static final Logger logger = LogManager.getLogger(CalalogController.class);
	@Autowired
	private ResourcesService resourcesService;

	/*
	 * 单文件上传
	 */
	@RequestMapping(value = "/upload", method = RequestMethod.POST)
	@ResponseBody
	public JsonResult uploadResources(HttpServletRequest request, @RequestParam("file") MultipartFile file) {
		logger.debug("Entry");

		CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());

		// 检查contentType是否为multipart/form-data
		if (multipartResolver.isMultipart(request)) {
			logger.debug("fileName:" + file.getOriginalFilename());

			int catalogId = Integer.parseInt(request.getParameter("catalogId"));
			
			int type = 0;
			String prefix = "_";
			String fileType = file.getContentType();
			if (fileType.contains("image")) {
				type = 1;
				prefix = "image_";
			} else if (fileType.contains("video")) {
				type = 2;
				prefix = "video_";
			}
			String newFileName = prefix + Utils.newFileName(file.getOriginalFilename());
			String path = Configuration.UPLOAD_PATH + newFileName;
			String url = Configuration.IMG_URL + newFileName;
			
			Timestamp createTime = Utils.long2Timestamp(System.currentTimeMillis());
			
			try {
				file.transferTo(new File(path));
				Resources resource = new Resources(url, type, catalogId, createTime, createTime);
				logger.debug("resource：" + resource.toString());
				resourcesService.addResource(resource);
			} catch (IllegalStateException e) {
				JsonResult jsonResult = new JsonResult(RetCode.ERROR_UPLOAD);
				jsonResult.setBody(e.getMessage());
				return jsonResult;
			} catch (IOException e) {
				JsonResult jsonResult = new JsonResult(RetCode.ERROR_UPLOAD);
				jsonResult.setBody(e.getMessage());
				return jsonResult;
			}
		} else {
			JsonResult jsonResult = new JsonResult(RetCode.ERROR_HTTP_PARAM);
			jsonResult.setBody("content_type类型错误！");
			return jsonResult;
		}
		
		JsonResult jsonResult = new JsonResult(RetCode.SUCCESS);
		return jsonResult;
	}
}
