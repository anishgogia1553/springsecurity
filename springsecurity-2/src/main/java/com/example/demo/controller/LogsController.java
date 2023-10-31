package com.example.demo.controller;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Schedular;
import com.example.demo.repository.SchedularService;



@RestController
public class LogsController {
	
	@Autowired
	private SchedularService schedularService;
	
	@GetMapping("/filteredData")
	public List<Schedular> findFilteredSchedular(@RequestParam String name,@RequestParam int status,@RequestParam String category,@RequestParam String date){
		
		System.out.println("in spring boot app");
		System.out.println("name is "+name);
		System.out.println("status is "+status);
		System.out.println("date is "+date);
		System.out.println("category is "+category);
		
		return schedularService.findAllSchedularByFilter(date, name, status, category);
	}

}
