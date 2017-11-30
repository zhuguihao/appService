/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.log.entity.SrtTablogmain;
import com.thinkgem.jeesite.modules.log.dao.SrtTablogmainDao;
import com.thinkgem.jeesite.modules.log.entity.SrtTablogsub;
import com.thinkgem.jeesite.modules.log.dao.SrtTablogsubDao;

/**
 * 操作日志生成Service
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Service
@Transactional(readOnly = true)
public class SrtTablogmainService extends CrudService<SrtTablogmainDao, SrtTablogmain> {

	@Autowired
	private SrtTablogsubDao srtTablogsubDao;
	
	public SrtTablogmain get(String id) {
		SrtTablogmain srtTablogmain = super.get(id);
		srtTablogmain.setSrtTablogsubList(srtTablogsubDao.findList(new SrtTablogsub(srtTablogmain)));
		return srtTablogmain;
	}
	
	public List<SrtTablogmain> findList(SrtTablogmain srtTablogmain) {
		return super.findList(srtTablogmain);
	}
	
	public Page<SrtTablogmain> findPage(Page<SrtTablogmain> page, SrtTablogmain srtTablogmain) {
		return super.findPage(page, srtTablogmain);
	}
	
	@Transactional(readOnly = false)
	public void save(SrtTablogmain srtTablogmain) {
		super.save(srtTablogmain);
		for (SrtTablogsub srtTablogsub : srtTablogmain.getSrtTablogsubList()){
			if (srtTablogsub.getId() == null){
				continue;
			}
			if (SrtTablogsub.DEL_FLAG_NORMAL.equals(srtTablogsub.getDelFlag())){
				if (StringUtils.isBlank(srtTablogsub.getId())){
					srtTablogsub.setSrtTablogMain(srtTablogmain);
					srtTablogsub.preInsert();
					srtTablogsubDao.insert(srtTablogsub);
				}else{
					srtTablogsub.preUpdate();
					srtTablogsubDao.update(srtTablogsub);
				}
			}else{
				srtTablogsubDao.delete(srtTablogsub);
			}
		}
	}
	
	@Transactional(readOnly = false)
	public void delete(SrtTablogmain srtTablogmain) {
		super.delete(srtTablogmain);
		srtTablogsubDao.delete(new SrtTablogsub(srtTablogmain));
	}
	
}