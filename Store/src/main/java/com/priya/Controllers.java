package com.priya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class Controllers {
	@Autowired
	StuRep rep;
	@RequestMapping("/addentry")
	public String add(Student s)
	{
		rep.save(s);
		return "entry.jsp";
	}
}
