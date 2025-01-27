package com.priya;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Controllers {
	@Autowired
	FruitRep rep;
	@RequestMapping("/addfruit")
	public String add(Fruit f)
	{
		rep.save(f);
		return "add.jsp";
	}
	@RequestMapping("/fetchfruit")
	public ModelAndView fetch(@RequestParam String name)
	{
		Fruit f = rep.findById(name).orElse(new Fruit());
		ModelAndView mv = new ModelAndView("fetchview");
		mv.addObject("fruit",f);
		return mv;
	}
	@RequestMapping("/updatefruit")
	public String update(String name,double price)
	{
		Fruit f = rep.findById(name).orElse(new Fruit());
		f.price=price;
		rep.save(f);
		return "update.jsp";
	}
	@RequestMapping("/deletefruit")
	public String update(String name)
	{
		rep.deleteById(name);
		return "delete.jsp";
	}
	
	@RequestMapping(path="/fruits",produces= {"application/xml"})
	@ResponseBody
	public Iterable<Fruit> getFruits()
	{
		return rep.findAll();
	}
	
	@RequestMapping("/fruits/{name}")
	@ResponseBody
	public Optional<Fruit> getByName(@PathVariable("name") String name)
	{
		return rep.findById(name);
	}
}