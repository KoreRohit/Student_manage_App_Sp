package org.techhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.techhub.model.Adminlogin;
import org.techhub.service.StudentService;

@CrossOrigin("http://localhost:3000")
@RestController
public class AdminController {
	
		@Autowired
		StudentService studService;
		List<Adminlogin> list;

		@PostMapping(value = "/adminregister")
		public String Adminlogin(@RequestBody Adminlogin al) {
			boolean b = studService.isAdminRegister(al);
			if (b) {
				return "Admin Rgister Success....";
			} else {
				return "Some Probleam is there....";
			}
		}
		
		@PostMapping(value="/login")
		public ResponseEntity<?> loginadmin(@RequestBody Adminlogin al){
			String username=al.getUsername();
			String password=al.getPassword();
			Adminlogin authenticateadmin=studService.authenticate(username, password);
			
			if(authenticateadmin!=null) {
				return ResponseEntity.ok(authenticateadmin);
			}else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username And Password");
			}
		}
}

