package com.example.demo.controller;
import com.example.demo.repository.*;
import com.example.demo.entity.*;
import java.util.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
//import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.RestController;

//@RestController
@org.springframework.stereotype.Controller
@RequestMapping("/sensor-1")
public class Controller {
	
	@Autowired
	Repository repo;

	@GetMapping("/getData")
	public List<Entity> getData()
	{
		return repo.findAll();
	}
	
	@GetMapping("/getLastData")
	public String getRecentData(Model model)
	{
		Entity entity=repo.findFirstByOrderByIdDesc();
		model.addAttribute("result", entity.getId());
		model.addAttribute("distanceinch", entity.getDistance_in_inch());
		model.addAttribute("distancecm", entity.getDistance_in_cm());
		return "index";
		
	}
//	@GetMapping("/display")
//	public String display() {
//		return "index";
//	}
}
