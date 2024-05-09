package org.techhub.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.techhub.model.Adminlogin;
import org.techhub.model.Mark;
import org.techhub.model.Student;
import org.techhub.model.Subject;
import org.techhub.service.StudentService;
@CrossOrigin("http://localhost:3000")
@RestController
public class StudentController {
	@Autowired
	StudentService studService;
	List<Student> list;

	@PostMapping(value = "/savestudent")
	public String studentregister(@RequestBody Student st) {
		boolean b = studService.isStudRegister(st);
		if (b) {
			return "Student Register Success....";
		} else {
			return "Some Probleam is there....";
		}
	}

	@PostMapping(value = "/savesubject")
	public String savesubject(@RequestBody Subject s) {
		boolean b = studService.isAddSubject(s);
		if (b) {
			return "subject added success....";
		} else {
			return "Some Probleam is there";
		}
	}

	@GetMapping(value = "/viewStudentdata")
	public List<Student> getStudentData() {
		return list = studService.getAllStudentdata();
	}

	@PostMapping("/marks")
	public Mark saveMarks(@RequestBody Mark mark) {
		return studService.saveMark(mark);
	}
	
	@GetMapping("/markid")
	public Mark getmarkid(@RequestBody Mark mark) {
		return studService.getMarkById(mark);
	}
	
	@PostMapping(value="/studlogin")
	public ResponseEntity<?> loginstudent(@RequestBody Student stud){
		String username=stud.getUsername();
		String password=stud.getPassword();
		Student authenticatestudent=studService.authenticatestudent(username, password);
		
		if(authenticatestudent!=null) {
//			return ResponseEntity.ok(authenticatestudent);
			return ResponseEntity.status(HttpStatus.OK).body(authenticatestudent);
		}else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid Username And Password");
		}
	}
	
//	@GetMapping(value="/getSpecific")
//	public List<Student> getSpecificStudentData() {
//		return list = studService.getAllStudentdata();
//	}

}
