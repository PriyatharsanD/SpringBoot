package com.priya.service;

import java.time.LocalTime;

import org.springframework.stereotype.Service;

@Service
public class WishService {

	public String getwish() {
		LocalTime localTime = LocalTime.now();
		int hours = localTime.getHour();
		if(hours<12)
			return "Good Morning";
		else if(hours>12 && hours<16)
			return "Good Afternoon";
		else
			return "Good Evening";
	}

}
