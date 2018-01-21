package com.zxl.bos.dao;

import java.util.List;

import com.zxl.bos.dao.base.IBaseDao;
import com.zxl.bos.domain.Subarea;

public interface ISubareaDao extends IBaseDao<Subarea> {

	void save(Subarea model);

	List<Object> findSubareasGroupByProvince();

}
