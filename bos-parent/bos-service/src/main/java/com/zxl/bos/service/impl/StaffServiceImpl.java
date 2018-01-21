package com.zxl.bos.service.impl;

import java.util.List;

import org.apache.commons.lang.StringUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.zxl.bos.dao.IStaffDao;
import com.zxl.bos.domain.Staff;
import com.zxl.bos.service.IStaffService;
import com.zxl.bos.utils.PageBean;

@Service
@Transactional
public class StaffServiceImpl implements IStaffService {
	@Autowired
	private IStaffDao staffDao;
	public void save(Staff model) {
		staffDao.save(model);
	}
	@Override
	public void pageQuery(PageBean pageBean) {
		staffDao.pageQuery(pageBean);
	}
	/**
	 * 取派员批量删除
	 * 逻辑删除，将deltag改为1
	 */
	@Override
	public void deleteBatch(String ids) {//1,2,3,4
		if(StringUtils.isNotBlank(ids)){
			String[] staffIds = ids.split(",");
			for (String id : staffIds) {
				staffDao.executeUpdate("staff.delete", id);
			}
		}
	}
	/**
	 * 根据id查询取派员
	 */
	@Override
	public Staff findById(String id) {
		return staffDao.findById(id);
	}
	/**
	 * 根据id修改取派员
	 */
	@Override
	public void update(Staff staff) {
		staffDao.update(staff);
	}
	/**
	 *  查询所有未删除的取派员
	 */
	@Override
	public List<Staff> findListNotDelete() {
		DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Staff.class);
		//添加过滤条件，deltag等于0
		detachedCriteria.add(Restrictions.eq("deltag", "0"));
		//detachedCriteria.add(Restrictions.ne("deltag", "1"));
		return staffDao.findByCriteria(detachedCriteria);
	}
}
