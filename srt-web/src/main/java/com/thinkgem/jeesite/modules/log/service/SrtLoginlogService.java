/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.log.entity.SrtLoginlog;
import com.thinkgem.jeesite.modules.log.dao.SrtLoginlogDao;

/**
 * 登录日志生成Service
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Service
@Transactional(readOnly = true)
public class SrtLoginlogService extends CrudService<SrtLoginlogDao, SrtLoginlog> {

	public SrtLoginlog get(String id) {
		return super.get(id);
	}
	
	public List<SrtLoginlog> findList(SrtLoginlog srtLoginlog) {
		return super.findList(srtLoginlog);
	}
	
	public Page<SrtLoginlog> findPage(Page<SrtLoginlog> page, SrtLoginlog srtLoginlog) {
		return super.findPage(page, srtLoginlog);
	}
	
	@Transactional(readOnly = false)
	public void save(SrtLoginlog srtLoginlog) {
		super.save(srtLoginlog);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrtLoginlog srtLoginlog) {
		super.delete(srtLoginlog);
	}
	
}