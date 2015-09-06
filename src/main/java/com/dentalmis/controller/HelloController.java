package com.dentalmis.controller;

import java.sql.Date;
import java.text.SimpleDateFormat;

import javax.servlet.ServletRequest;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.ServletRequestDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/account")
public class HelloController {

	@RequestMapping(value="hello.do", method= RequestMethod.POST)
	public String Hello(@RequestParam("userName")String name, Model model)
	{
		model.addAttribute("result", "hello : " + name);

		return "login";
	}
	
	@RequestMapping("login.do")
	public String Login(String userName)
	{
		return "login";
	}
	
	/*时间属性的编辑器*/
	@InitBinder
	public void initBinder(ServletRequestDataBinder binder)
	{
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		CustomDateEditor cusd = new CustomDateEditor(sdf, true);
		binder.registerCustomEditor(Date.class, cusd);
	}
}
