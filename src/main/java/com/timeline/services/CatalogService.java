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

	public void addCatalog(CatalogVO catalogVO) {

		Timestamp time = Utils.long2Timestamp(catalogVO.getTime());
		Timestamp createTime = Utils.long2Timestamp(System.currentTimeMillis());
		Timestamp updateTime = createTime;
		Catalog catalog = new Catalog(catalogVO.getName(), catalogVO.getLocation(), time, catalogVO.getDescription(), createTime,
				updateTime);

		catalogDao.insertCatalog(catalog);
	}

	public List<CatalogVO> queryCatalog() {
		List<Catalog> list = catalogDao.queryCatalog();
		List<CatalogVO> resultList = new ArrayList<CatalogVO>();
		for (int i = 0; i < list.size(); i++) {
			Catalog catalogItem = list.get(i);
			CatalogVO item = new CatalogVO(catalogItem.getId(), catalogItem.getName(), catalogItem.getLocation(),
					Utils.timestamp2Long(catalogItem.getTime()), catalogItem.getDescription());
			
			resultList.add(item);
		}
		
		return resultList;
	}

}
