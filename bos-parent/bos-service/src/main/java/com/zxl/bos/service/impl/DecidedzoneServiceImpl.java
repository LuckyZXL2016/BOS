package com.zxl.bos.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxl.bos.dao.IDecidedzoneDao;
import com.zxl.bos.dao.ISubareaDao;
import com.zxl.bos.domain.Decidedzone;
import com.zxl.bos.domain.Subarea;
import com.zxl.bos.service.IDecidedzoneService;
import com.zxl.bos.utils.PageBean;

@Service
@Transactional
public class DecidedzoneServiceImpl implements IDecidedzoneService {
	@Autowired
	private IDecidedzoneDao decidedzoneDao;
	@Autowired
	private ISubareaDao subareaDao;
	
	/**
	 * 添加定区，同时关联分区
	 */
	@Override
	public void save(Decidedzone model, String[] subareaid) {
		decidedzoneDao.save(model);
		for (String id : subareaid) {
			Subarea subarea = subareaDao.findById(id);
			//model.getSubareas().add(subarea);一方（定区）已经放弃维护外键权利，只能由多方（分区）负责维护
			subarea.setDecidedzone(model);
		}
	}

	@Override
	public void pageQuery(PageBean pageBean) {
		decidedzoneDao.pageQuery(pageBean);
	}

}
