/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apply.dao;

import com.thinkgem.jeesite.common.persistence.CrudDao;
import com.thinkgem.jeesite.common.persistence.annotation.MyBatisDao;
import com.thinkgem.jeesite.modules.apply.entity.SrtCaptcha;

/**
 * 手机验证码生成DAO接口
 * @author LiangYouKu
 * @version 2017-09-13
 */
@MyBatisDao
public interface SrtCaptchaDao extends CrudDao<SrtCaptcha> {
	
}