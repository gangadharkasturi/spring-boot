package com.gk.controller;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IntrnlztnController {

	@Autowired
	public ResourceBundleMessageSource msgSource;
	
	@GetMapping(value="/goodmorning")
	public String getGoodMorning(@RequestHeader(name="Accept-Language",required=false) Locale locale) {
		
		return msgSource.getMessage("good.morning.msg", null, locale);
	}
	
	@GetMapping(value="/hello")
	public String hello() {
		return "Hello";
	}
}
