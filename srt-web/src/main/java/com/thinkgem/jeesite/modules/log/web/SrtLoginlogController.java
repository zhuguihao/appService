/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.log.web;

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
import com.thinkgem.jeesite.modules.log.entity.SrtLoginlog;
import com.thinkgem.jeesite.modules.log.service.SrtLoginlogService;

/**
 * 登录日志生成Controller
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/log/srtLoginlog")
public class SrtLoginlogController extends BaseController {

	@Autowired
	private SrtLoginlogService srtLoginlogService;
	
	@ModelAttribute
	public SrtLoginlog get(@RequestParam(required=false) String id) {
		SrtLoginlog entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srtLoginlogService.get(id);
		}
		if (entity == null){
			entity = new SrtLoginlog();
		}
		return entity;
	}
	
	@RequiresPermissions("log:srtLoginlog:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrtLoginlog srtLoginlog, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrtLoginlog> page = srtLoginlogService.findPage(new Page<SrtLoginlog>(request, response), srtLoginlog); 
		model.addAttribute("page", page);
		return "modules/log/srtLoginlogList";
	}

	@RequiresPermissions("log:srtLoginlog:view")
	@RequestMapping(value = "form")
	public String form(SrtLoginlog srtLoginlog, Model model) {
		model.addAttribute("srtLoginlog", srtLoginlog);
		return "modules/log/srtLoginlogForm";
	}

	@RequiresPermissions("log:srtLoginlog:edit")
	@RequestMapping(value = "save")
	public String save(SrtLoginlog srtLoginlog, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srtLoginlog)){
			return form(srtLoginlog, model);
		}
		srtLoginlogService.save(srtLoginlog);
		addMessage(redirectAttributes, "保存用户登录日志成功");
		return "redirect:"+Global.getAdminPath()+"/log/srtLoginlog/?repage";
	}
	
	@RequiresPermissions("log:srtLoginlog:edit")
	@RequestMapping(value = "delete")
	public String delete(SrtLoginlog srtLoginlog, RedirectAttributes redirectAttributes) {
		srtLoginlogService.delete(srtLoginlog);
		addMessage(redirectAttributes, "删除用户登录日志成功");
		return "redirect:"+Global.getAdminPath()+"/log/srtLoginlog/?repage";
	}

}