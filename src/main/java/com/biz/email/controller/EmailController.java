package com.biz.email.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.biz.email.model.EmailVO;
import com.biz.email.service.EmailService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class EmailController {

	@Autowired
	EmailService emailService;
	
	@RequestMapping(value="write", method=RequestMethod.GET)
	public String writeEmail(@ModelAttribute EmailVO emailVO, Model model) {
		
		model.addAttribute("BODY", "WRITE");
		
		return "home";
	}
	
	@RequestMapping(value="write", method=RequestMethod.POST)
	public String writeEmail(@ModelAttribute EmailVO emailVO, Model model, MultipartHttpServletRequest request) {
		
		log.debug(emailVO.toString());
		emailService.insert(emailVO, request);
		
		return "home";
	}
	
	@RequestMapping(value="list", method=RequestMethod.GET)
	public String emailList(Model model) {
		
		model.addAttribute("BODY", "LIST");
		model.addAttribute("LIST", emailService.selectAll());
		
		return "home";
	}
	
	@RequestMapping(value="update", method=RequestMethod.GET)
	public String updateEmail(Model model, @RequestParam long id, @ModelAttribute EmailVO emailVO) {
		
		model.addAttribute("BODY", "UPDATE");
		model.addAttribute("VO", emailService.findByID(id));
		
		return "home";
	}
	
	@RequestMapping(value="update", method=RequestMethod.POST)
	public String updateEmail(Model model, @ModelAttribute EmailVO emailVO, MultipartHttpServletRequest request) {
		
		emailService.update(emailVO, request);
		
		return "home";
	}
	
	@RequestMapping(value="delete", method=RequestMethod.GET)
	public String deleteEmail(@RequestParam long id) {
		
		emailService.delete(id);
		
		return "home";
	}
	
}




















