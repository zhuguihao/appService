/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apply.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.service.CrudService;
import com.thinkgem.jeesite.modules.apply.entity.SrtCaptcha;
import com.thinkgem.jeesite.modules.apply.dao.SrtCaptchaDao;

/**
 * 手机验证码生成Service
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Service
@Transactional(readOnly = true)
public class SrtCaptchaService extends CrudService<SrtCaptchaDao, SrtCaptcha> {

	public SrtCaptcha get(String id) {
		return super.get(id);
	}
	
	public List<SrtCaptcha> findList(SrtCaptcha srtCaptcha) {
		return super.findList(srtCaptcha);
	}
	
	public Page<SrtCaptcha> findPage(Page<SrtCaptcha> page, SrtCaptcha srtCaptcha) {
		return super.findPage(page, srtCaptcha);
	}
	
	@Transactional(readOnly = false)
	public void save(SrtCaptcha srtCaptcha) {
		super.save(srtCaptcha);
	}
	
	@Transactional(readOnly = false)
	public void delete(SrtCaptcha srtCaptcha) {
		super.delete(srtCaptcha);
	}
	
}