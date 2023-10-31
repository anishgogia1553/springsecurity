package com.example.demo.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.demo.repository.SchedularService;
//import com.example.demo.model.User;
import com.example.demo.service.SecurityService;


@Controller
public class UserController {


	@Autowired
	private SecurityService securityService;

	@Autowired
	private SchedularService schedularService;

//	@GetMapping("/registration")
//	public String registration(Model model) {
//		if (securityService.isAuthenticated()) {
//			return "redirect:/";
//		}
//
//		model.addAttribute("userForm", new User());
//
//		return "registration";
//	}

//	@PostMapping("/registration")
//	public String registration(@ModelAttribute("userForm") User userForm) {
//
//		userService.save(userForm);
//		securityService.autoLogin(userForm.getUsername(), userForm.getPassword());
//
//		return "redirect:/welcome";
//	}

	@GetMapping("/login")
	public String login(Model model, String error, String logout) {
		if (securityService.isAuthenticated()) {
			return "redirect:/";
		}

		if (error != null)
			model.addAttribute("error", "Your username and password is invalid.");

		if (logout != null)
			model.addAttribute("message", "You have been logged out successfully.");

		return "login";
	}

	@GetMapping({ "/", "/welcome" })
	public String welcome(Model model) {
		return "welcome";
	}

	@GetMapping({ "/schedulars" })
	public String schedular(Model model) {
		model.addAttribute("schedulars", schedularService.findAllSchedular());
		return "table";
	}
	@GetMapping({ "/schedulars2" })
	public String schedular2(Model model) {
		
		model.addAttribute("mains", schedularService.findAllSchedularMain());
		model.addAttribute("categories", schedularService.findAllSchedularCategory());
		model.addAttribute("schedulars", schedularService.findAllSchedular());
		return "table2";
	}
	
	
//	@GetMapping("/get-logs/{path}")
//    public ResponseEntity<InputStreamResource> getTermsConditions(@PathVariable("path") String path) throws FileNotFoundException {
//		
//		String filePath = path;
//		filePath = filePath;
//		System.out.println(path);
//
//        File file = new File(filePath);
//        
//        HttpHeaders headers = new HttpHeaders();      
//        headers.add("content-disposition", "inline;filename=" +"log12");
//        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));
//
//        return ResponseEntity.ok()
//                .headers(headers)
//                .contentLength(file.length())
//                .contentType(MediaType.parseMediaType("application/log"))
//                .body(resource);
//        
//    }
	
	@GetMapping("/get-log")
    public ResponseEntity<InputStreamResource> getlogs(@RequestParam(value = "path") String path) throws FileNotFoundException {
		String filePath = path;
		System.out.println(path);
        File file = new File(filePath);
        
        HttpHeaders headers = new HttpHeaders();      
        headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file.txt");
        InputStreamResource resource = new InputStreamResource(new FileInputStream(file));

        return ResponseEntity.ok()
                .headers(headers)
                .contentLength(file.length())
                .contentType(MediaType.parseMediaType("application/log"))
                .body(resource);
        
    }
	
   
//	@GetMapping("/get-file/{path}")
//	public ResponseEntity<Resource> downloadFile2(@PathVariable("path") String path) {
//	    // Load file from classpath
//	    Resource resource = new ClassPathResource("/"+path);
//
//	    // Set content type and attachment header
//	    HttpHeaders headers = new HttpHeaders();
//	    headers.add(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=file.txt");
//	    headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
//
//	    return ResponseEntity
//	            .ok()
//	            .headers(headers)
//	            .body(resource);
//	}
	

}
