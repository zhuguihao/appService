/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apply.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.apply.entity.SrtSubscription;
import com.thinkgem.jeesite.modules.apply.dao.SrtSubscriptionDao;

/**
 * 订阅生成Service
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Service
@Transactional(readOnly = true)
public class SrtSubscriptionService extends CrudService<SrtSubscriptionDao, SrtSubscription> {

	public SrtSubscription get(String id) {
		return super.get(id);
	}
	
	public List<SrtSubscription> findList(SrtSubscription srtSubscription) {
		return super.findList(srtSubscription);
	}
	
	public Page<SrtSubscription> findPage(Page<SrtSubscription> page, SrtSubscription srtSubscription) {
		return super.findPage(page, srtSubscription);
	}
	
	@Transactional(readOnly = false)
	public void save(SrtSubscription srtSubscription) {
		super.save(srtSubscription);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrtSubscription srtSubscription) {
		super.delete(srtSubscription);
	}
	
}