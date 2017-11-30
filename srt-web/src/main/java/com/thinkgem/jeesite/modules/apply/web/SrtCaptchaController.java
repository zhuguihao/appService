/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.apply.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.thinkgem.jeesite.common.config.Global;
import com.thinkgem.jeesite.common.persistence.Page;
import com.thinkgem.jeesite.common.web.BaseController;
import com.thinkgem.jeesite.common.utils.StringUtils;
import com.thinkgem.jeesite.modules.apply.entity.SrtCaptcha;
import com.thinkgem.jeesite.modules.apply.service.SrtCaptchaService;

/**
 * 手机验证码生成Controller
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/apply/srtCaptcha")
public class SrtCaptchaController extends BaseController {

	@Autowired
	private SrtCaptchaService srtCaptchaService;
	
	@ModelAttribute
	public SrtCaptcha get(@RequestParam(required=false) String id) {
		SrtCaptcha entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srtCaptchaService.get(id);
		}
		if (entity == null){
			entity = new SrtCaptcha();
		}
		return entity;
	}
	
	@RequiresPermissions("apply:srtCaptcha:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrtCaptcha srtCaptcha, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrtCaptcha> page = srtCaptchaService.findPage(new Page<SrtCaptcha>(request, response), srtCaptcha); 
		model.addAttribute("page", page);
		return "modules/apply/srtCaptchaList";
	}

	@RequiresPermissions("apply:srtCaptcha:view")
	@RequestMapping(value = "form")
	public String form(SrtCaptcha srtCaptcha, Model model) {
		model.addAttribute("srtCaptcha", srtCaptcha);
		return "modules/apply/srtCaptchaForm";
	}

	@RequiresPermissions("apply:srtCaptcha:edit")
	@RequestMapping(value = "save")
	public String save(SrtCaptcha srtCaptcha, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srtCaptcha)){
			return form(srtCaptcha, model);
		}
		srtCaptchaService.save(srtCaptcha);
		addMessage(redirectAttributes, "保存手机验证码成功");
		return "redirect:"+Global.getAdminPath()+"/apply/srtCaptcha/?repage";
	}
	
	@RequiresPermissions("apply:srtCaptcha:edit")
	@RequestMapping(value = "delete")
	public String delete(SrtCaptcha srtCaptcha, RedirectAttributes redirectAttributes) {
		srtCaptchaService.delete(srtCaptcha);
		addMessage(redirectAttributes, "删除手机验证码成功");
		return "redirect:"+Global.getAdminPath()+"/apply/srtCaptcha/?repage";
	}

}