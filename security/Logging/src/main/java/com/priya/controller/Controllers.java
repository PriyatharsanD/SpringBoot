package com.priya.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.priya.service.WishService;

@RestController
public class Controllers {
	
	private final Logger log = LoggerFactory.getLogger(Controllers.class);
	@Autowired
	WishService wishService;
	
	@RequestMapping("/wish")
	public String getWish()
	{
		log.info("Request call is  success");
		return wishService.getwish();
	}

}
