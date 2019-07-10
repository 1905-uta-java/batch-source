package com.revature.controller;

import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.revature.exception.SandwichNotFoundException;
import com.revature.model.Sandwich;
import com.revature.service.SandwichService;

@Controller // stereotype annotation, registering our controller with our IOC container (Spring Context)
@RequestMapping("/sandwiches")
public class SandwichController {
	
	@Autowired // wiring our beans together to achieve dependency injection - IOC container provides an instance
	private SandwichService ss;
	
//	@RequestMapping(method=RequestMethod.GET, value="/sandwiches") // indicate the type of request + uri that will be handled here
//	@GetMapping("/sandwiches")
	@GetMapping
	@ResponseBody // bypass the view resolver and send what we return in the HTTP response
	public List<Sandwich> getAllSandwiches(){
		return ss.getAll();
	}
	
	@GetMapping("/{id}")
	@ResponseBody
	public Sandwich getSandwichById(@PathVariable("id") int sId) {
		Sandwich s = ss.getById(sId);
		if(s == null) {
			throw new SandwichNotFoundException();
		} else {
			return s;
		} 
	}
	
//	@GetMapping("/search") // this does not follow RESTful conventions 
//	@ResponseBody
//	public Sandwich getSandwich(@RequestParam("id") int id) {
//		return ss.getById(id);
//	}
	
//	@GetMapping("/search") // this does not follow RESTful conventions 
//	@ResponseBody
//	public Sandwich getSandwich(HttpServletRequest req) {
//		String idStr = req.getParameter("id");
//		return ss.getById(Integer.parseInt(idStr));
//	}
	
//	@PostMapping
//	@ResponseBody
//	public String addSandwich(@RequestParam("bread")String bread, @RequestParam("meat") String meat, @RequestParam("hasCrust")Boolean hasCrust) {
//		Sandwich sandwich = new Sandwich(bread, meat, hasCrust);
//		return null;
//	}
	
	@PostMapping
	@ResponseBody
	public String addSandwich(@RequestBody Sandwich s, HttpServletResponse response) {
		ss.create(s);
		response.setStatus(201);
		return "added sandwich";
	}

	
	
	
}
