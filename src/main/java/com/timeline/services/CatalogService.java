package com.timeline.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.dao.CatalogDao;
import com.timeline.pojos.Catalog;

@Service
public class CatalogService {
	
	@Autowired
	private CatalogDao catalogDao;
	
	public void addCatalog(Catalog catalog) {
		catalogDao.insertCatalog(catalog);
	}

}
