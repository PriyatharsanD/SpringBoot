package com.priya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {
	@Autowired
	StuRepo rep;
	@RequestMapping("/addstu")
	public String add(Student s)
	{	
		rep.save(s);
		return "home.jsp";
	}
}
