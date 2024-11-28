package com.priya;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {
	@Autowired
	LapRep rep;
	@RequestMapping("/addlap")
	public String addLap(Laptop l)
	{
		rep.save(l);
		return "add.jsp";
	}
	@RequestMapping("/fetch")
	public ModelAndView getlap()
	{
		ModelAndView mv = new ModelAndView("fetch");
		mv.addObject("lap", rep.findById(11));
		return mv;
	}
}
