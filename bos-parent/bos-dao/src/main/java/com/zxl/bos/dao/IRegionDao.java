package com.zxl.bos.dao;

import java.util.List;

import com.zxl.bos.dao.base.IBaseDao;
import com.zxl.bos.domain.Region;

public interface IRegionDao extends IBaseDao<Region> {

	List<Region> findListByQ(String q);

}
