package com.timeline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.dao.ResourcesDao;
import com.timeline.entity.Resources;

@Service
public class ResourcesService {

	@Autowired
	private ResourcesDao resourcesDao;

	public void addResource(Resources resource) {
		
		resourcesDao.addResource(resource);
	}

}
