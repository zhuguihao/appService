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
import com.thinkgem.jeesite.modules.apply.entity.SrtSubscription;
import com.thinkgem.jeesite.modules.apply.service.SrtSubscriptionService;

/**
 * 订阅生成Controller
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/apply/srtSubscription")
public class SrtSubscriptionController extends BaseController {

	@Autowired
	private SrtSubscriptionService srtSubscriptionService;
	
	@ModelAttribute
	public SrtSubscription get(@RequestParam(required=false) String id) {
		SrtSubscription entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srtSubscriptionService.get(id);
		}
		if (entity == null){
			entity = new SrtSubscription();
		}
		return entity;
	}
	
	@RequiresPermissions("apply:srtSubscription:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrtSubscription srtSubscription, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrtSubscription> page = srtSubscriptionService.findPage(new Page<SrtSubscription>(request, response), srtSubscription); 
		model.addAttribute("page", page);
		return "modules/apply/srtSubscriptionList";
	}

	@RequiresPermissions("apply:srtSubscription:view")
	@RequestMapping(value = "form")
	public String form(SrtSubscription srtSubscription, Model model) {
		model.addAttribute("srtSubscription", srtSubscription);
		return "modules/apply/srtSubscriptionForm";
	}

	@RequiresPermissions("apply:srtSubscription:edit")
	@RequestMapping(value = "save")
	public String save(SrtSubscription srtSubscription, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srtSubscription)){
			return form(srtSubscription, model);
		}
		srtSubscriptionService.save(srtSubscription);
		addMessage(redirectAttributes, "保存订阅成功");
		return "redirect:"+Global.getAdminPath()+"/apply/srtSubscription/?repage";
	}
	
	@RequiresPermissions("apply:srtSubscription:edit")
	@RequestMapping(value = "delete")
	public String delete(SrtSubscription srtSubscription, RedirectAttributes redirectAttributes) {
		srtSubscriptionService.delete(srtSubscription);
		addMessage(redirectAttributes, "删除订阅成功");
		return "redirect:"+Global.getAdminPath()+"/apply/srtSubscription/?repage";
	}

}