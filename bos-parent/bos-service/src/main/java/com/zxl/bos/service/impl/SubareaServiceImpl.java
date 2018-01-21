package com.zxl.bos.service.impl;

import java.util.List;

import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxl.bos.dao.ISubareaDao;
import com.zxl.bos.domain.Subarea;
import com.zxl.bos.service.ISubareaService;
import com.zxl.bos.utils.PageBean;

@Service
@Transactional
public class SubareaServiceImpl implements ISubareaService {
	@Autowired
	private ISubareaDao subareaDao;
	
	@Override
	public void save(Subarea model) {
		subareaDao.save(model);
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		subareaDao.pageQuery(pageBean);
	}

	@Override
	public List<Subarea> findAll() {
		return subareaDao.findAll();
	}

	/**
	 * 查询所有未关联到定区的分区
	 */
	@Override
	public List<Subarea> findListNotAssociation() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件,分区对象中decidedzone属性为null
		detachedCriteria.add(Restrictions.isNull("decidedzone"));
		return subareaDao.findByCriteria(detachedCriteria);
	}

	/**
	 * 根据定区id查询关联的分区
	 */
	@Override
	public List<Subarea> findListByDecidedzoneId(String decidedzoneId) {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Subarea.class);
		//添加过滤条件
		detachedCriteria.add(Restrictions.eq("decidedzone.id", decidedzoneId));
		return subareaDao.findByCriteria(detachedCriteria);
	}

	@Override
	public List<Object> findSubareasGroupByProvince() {
		return subareaDao.findSubareasGroupByProvince();
	}

}
