package com.zhangb.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.zhangb.entity.Protocol;
import com.zhangb.service.ProtocolService;

@Controller
@RequestMapping("/pro")
public class ProtocolController {
	@Autowired
	ProtocolService protocolService;
	
	@RequestMapping("/index")
	public String queryProtocol() {
		
		return "/index";
		
	}
	@RequestMapping("queryById")
	public ModelAndView queryById(HttpServletRequest request){
		
		String id = request.getParameter("id");
		ModelAndView mv = new ModelAndView();
		Protocol ps = protocolService.selectByPrimaryKey(id);
		mv.setViewName("result");
		mv.addObject("ps",ps);
		return mv;
	}
	

}
