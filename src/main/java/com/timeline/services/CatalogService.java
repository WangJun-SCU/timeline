package com.timeline.services;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.timeline.common.Utils;
import com.timeline.dao.CatalogDao;
import com.timeline.entity.Catalog;
import com.timeline.vo.CatalogVO;

@Service
public class CatalogService {

	@Autowired
	private CatalogDao catalogDao;

	public void addCatalog(CatalogVO catalog) {

		Timestamp time = Utils.long2Timestamp(catalog.getTime());
		Timestamp createTime = Utils.long2Timestamp(System.currentTimeMillis());
		Timestamp updateTime = createTime;
		Catalog catalogVO = new Catalog(catalog.getName(), catalog.getLocation(), time, catalog.getDescription(), createTime,
				updateTime);

		catalogDao.insertCatalog(catalogVO);
	}

	public List<CatalogVO> queryCatalog() {
		List<Catalog> list = catalogDao.queryCatalog();
		List<CatalogVO> resultList = new ArrayList<CatalogVO>();
		for (int i = 0; i < list.size(); i++) {
			Catalog catalogItem = list.get(i);
			CatalogVO item = new CatalogVO(catalogItem.getName(), catalogItem.getLocation(),
					Utils.timestamp2Long(catalogItem.getTime()), catalogItem.getDescription());
			
			resultList.add(item);
		}
		
		return resultList;
	}

}
