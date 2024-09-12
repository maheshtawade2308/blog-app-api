package com.comptask.userManagement.controller;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.comptask.userManagement.config.EmailDto;
import com.comptask.userManagement.config.GmailConfig;
import com.comptask.userManagement.props.AppProperties;

@Controller
public class EmailController {
	
	@Autowired
	private GmailConfig config;
	
	@Autowired
	private AppProperties appProperties;
	
	@GetMapping("/sendEmail")
	public String loadEmail(Model model) {
		
		EmailDto mail = new EmailDto();
		
		model.addAttribute("mail", mail);
		
		return "mails";
	}
	
	@PostMapping("/email")
	public String sendMail(EmailDto emailDto, Model model) {
		
		Map<String, String> mapMessages = appProperties.getMessages();
		boolean sendMail = config.sendMail(
				emailDto.getTo(),
				emailDto.getFrom(), 
				emailDto.getSubject(), 
				emailDto.getText());
		
		if(sendMail) {
			model.addAttribute("SUCCESS", mapMessages.get("sentMailSuccess"));
		}
		else {
			model.addAttribute("sendFailed", mapMessages.get("sendFailed"));
		}
		return "emailStatus";
	}
	

}
