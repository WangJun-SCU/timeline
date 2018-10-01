package com.timeline.dao;

import java.util.List;

import com.timeline.entity.Catalog;

public interface CatalogDao {
	
	public void insertCatalog(Catalog catalog);

	public List<Catalog> queryCatalog();
}
