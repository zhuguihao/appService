/**
 * Copyright &copy; 2012-2016 <a href="https://github.com/thinkgem/jeesite">JeeSite</a> All rights reserved.
 */
package com.thinkgem.jeesite.modules.bd.web;

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
import com.thinkgem.jeesite.modules.bd.entity.SrtTopbanner;
import com.thinkgem.jeesite.modules.bd.service.SrtTopbannerService;

/**
 * 首页banner生成Controller
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/bd/srtTopbanner")
public class SrtTopbannerController extends BaseController {

	@Autowired
	private SrtTopbannerService srtTopbannerService;
	
	@ModelAttribute
	public SrtTopbanner get(@RequestParam(required=false) String id) {
		SrtTopbanner entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srtTopbannerService.get(id);
		}
		if (entity == null){
			entity = new SrtTopbanner();
		}
		return entity;
	}
	
	@RequiresPermissions("bd:srtTopbanner:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrtTopbanner srtTopbanner, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrtTopbanner> page = srtTopbannerService.findPage(new Page<SrtTopbanner>(request, response), srtTopbanner); 
		model.addAttribute("page", page);
		return "modules/bd/srtTopbannerList";
	}

	@RequiresPermissions("bd:srtTopbanner:view")
	@RequestMapping(value = "form")
	public String form(SrtTopbanner srtTopbanner, Model model) {
		model.addAttribute("srtTopbanner", srtTopbanner);
		return "modules/bd/srtTopbannerForm";
	}

	@RequiresPermissions("bd:srtTopbanner:edit")
	@RequestMapping(value = "save")
	public String save(SrtTopbanner srtTopbanner, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srtTopbanner)){
			return form(srtTopbanner, model);
		}
		srtTopbannerService.save(srtTopbanner);
		addMessage(redirectAttributes, "保存首页banner成功");
		return "redirect:"+Global.getAdminPath()+"/bd/srtTopbanner/?repage";
	}
	
	@RequiresPermissions("bd:srtTopbanner:edit")
	@RequestMapping(value = "delete")
	public String delete(SrtTopbanner srtTopbanner, RedirectAttributes redirectAttributes) {
		srtTopbannerService.delete(srtTopbanner);
		addMessage(redirectAttributes, "删除首页banner成功");
		return "redirect:"+Global.getAdminPath()+"/bd/srtTopbanner/?repage";
	}

}