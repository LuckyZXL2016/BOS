package com.zxl.bos.service;

import java.util.List;

import com.zxl.bos.domain.Subarea;
import com.zxl.bos.utils.PageBean;

public interface ISubareaService {

	void save(Subarea model);

	void pageQuery(PageBean pageBean);

	List<Subarea> findAll();

	List<Subarea> findListNotAssociation();

	List<Subarea> findListByDecidedzoneId(String decidedzoneId);

	List<Object> findSubareasGroupByProvince();

}
