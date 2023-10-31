package com.example.demo.repository;

import java.util.Date;
import java.util.List;

import com.example.demo.model.Schedular;
import com.example.demo.model.SchedularCategory;
import com.example.demo.model.SchedularMain;

public interface SchedularRepository {
	List<Schedular> findAllSchedular();
	List<SchedularMain> findAllSchedularMain();
	List<SchedularCategory> findAllSchedularCategory();
	List<Schedular> findAllSchedularByFilter(String date,String name,int status, String category);
	
	

}
