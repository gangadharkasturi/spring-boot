package com.gk.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
/**
 * 
 * @author Gangadhar
 *
 */
@RestController
public class IntrnlztnController {

	@Autowired
	public ResourceBundleMessageSource msgSource;
	
	@GetMapping(value="/goodmorning")
	public String getGoodMorning() {
		
		return msgSource.getMessage("good.morning.msg", null, LocaleContextHolder.getLocale());
	}
	
	@GetMapping(value="/hello")
	public String hello() {
		return "Hello";
	}
}
