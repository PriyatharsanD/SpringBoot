package com.priya;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {
	@GetMapping("/add")
	public ModelAndView addObject(Student s)
	{
		ModelAndView mv = new ModelAndView("display");
		mv.addObject("stu",s);
		return mv;
	}
}
