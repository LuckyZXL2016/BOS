package com.zxl.bos.service;

import java.util.List;

import com.zxl.bos.domain.Region;
import com.zxl.bos.utils.PageBean;

public interface IRegionService {

	void saveBatch(List<Region> regionList);

	void pageQuery(PageBean pageBean);

	List<Region> findAll();

	List<Region> findListByQ(String q);

}
