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
import com.thinkgem.jeesite.modules.log.entity.SrtTablogmain;
import com.thinkgem.jeesite.modules.log.service.SrtTablogmainService;

/**
 * 操作日志生成Controller
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/log/srtTablogmain")
public class SrtTablogmainController extends BaseController {

	@Autowired
	private SrtTablogmainService srtTablogmainService;
	
	@ModelAttribute
	public SrtTablogmain get(@RequestParam(required=false) String id) {
		SrtTablogmain entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srtTablogmainService.get(id);
		}
		if (entity == null){
			entity = new SrtTablogmain();
		}
		return entity;
	}
	
	@RequiresPermissions("log:srtTablogmain:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrtTablogmain srtTablogmain, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrtTablogmain> page = srtTablogmainService.findPage(new Page<SrtTablogmain>(request, response), srtTablogmain); 
		model.addAttribute("page", page);
		return "modules/log/srtTablogmainList";
	}

	@RequiresPermissions("log:srtTablogmain:view")
	@RequestMapping(value = "form")
	public String form(SrtTablogmain srtTablogmain, Model model) {
		model.addAttribute("srtTablogmain", srtTablogmain);
		return "modules/log/srtTablogmainForm";
	}

	@RequiresPermissions("log:srtTablogmain:edit")
	@RequestMapping(value = "save")
	public String save(SrtTablogmain srtTablogmain, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srtTablogmain)){
			return form(srtTablogmain, model);
		}
		srtTablogmainService.save(srtTablogmain);
		addMessage(redirectAttributes, "保存操作日志成功");
		return "redirect:"+Global.getAdminPath()+"/log/srtTablogmain/?repage";
	}
	
	@RequiresPermissions("log:srtTablogmain:edit")
	@RequestMapping(value = "delete")
	public String delete(SrtTablogmain srtTablogmain, RedirectAttributes redirectAttributes) {
		srtTablogmainService.delete(srtTablogmain);
		addMessage(redirectAttributes, "删除操作日志成功");
		return "redirect:"+Global.getAdminPath()+"/log/srtTablogmain/?repage";
	}

}