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
import com.thinkgem.jeesite.modules.bd.entity.SrtTag;
import com.thinkgem.jeesite.modules.bd.service.SrtTagService;

/**
 * 标签生成Controller
 * @author LiangYouKu
 * @version 2017-09-13
 */
@Controller
@RequestMapping(value = "${adminPath}/bd/srtTag")
public class SrtTagController extends BaseController {

	@Autowired
	private SrtTagService srtTagService;
	
	@ModelAttribute
	public SrtTag get(@RequestParam(required=false) String id) {
		SrtTag entity = null;
		if (StringUtils.isNotBlank(id)){
			entity = srtTagService.get(id);
		}
		if (entity == null){
			entity = new SrtTag();
		}
		return entity;
	}
	
	@RequiresPermissions("bd:srtTag:view")
	@RequestMapping(value = {"list", ""})
	public String list(SrtTag srtTag, HttpServletRequest request, HttpServletResponse response, Model model) {
		Page<SrtTag> page = srtTagService.findPage(new Page<SrtTag>(request, response), srtTag); 
		model.addAttribute("page", page);
		return "modules/bd/srtTagList";
	}

	@RequiresPermissions("bd:srtTag:view")
	@RequestMapping(value = "form")
	public String form(SrtTag srtTag, Model model) {
		model.addAttribute("srtTag", srtTag);
		return "modules/bd/srtTagForm";
	}

	@RequiresPermissions("bd:srtTag:edit")
	@RequestMapping(value = "save")
	public String save(SrtTag srtTag, Model model, RedirectAttributes redirectAttributes) {
		if (!beanValidator(model, srtTag)){
			return form(srtTag, model);
		}
		srtTagService.save(srtTag);
		addMessage(redirectAttributes, "保存标签成功");
		return "redirect:"+Global.getAdminPath()+"/bd/srtTag/?repage";
	}
	
	@RequiresPermissions("bd:srtTag:edit")
	@RequestMapping(value = "delete")
	public String delete(SrtTag srtTag, RedirectAttributes redirectAttributes) {
		srtTagService.delete(srtTag);
		addMessage(redirectAttributes, "删除标签成功");
		return "redirect:"+Global.getAdminPath()+"/bd/srtTag/?repage";
	}

}