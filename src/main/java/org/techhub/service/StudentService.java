package org.techhub.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.techhub.model.Adminlogin;
import org.techhub.model.Mark;
import org.techhub.model.Student;
import org.techhub.model.Subject;
import org.techhub.repository.AdminRepository;
import org.techhub.repository.MarkRepository;
import org.techhub.repository.StudentRepository;
import org.techhub.repository.SubjectRepository;

@Service("studService")
public class StudentService {
	@Autowired
	StudentRepository studRepo;
	@Autowired
	AdminRepository admRepo;
	@Autowired
	SubjectRepository subRepo;

	@Autowired
	MarkRepository markRepository;

	List<Student> list = new ArrayList<Student>();
	List<Mark> list1=new ArrayList<Mark>();

	public boolean isStudRegister(Student st) {
		return studRepo.save(st) != null ? true : false;
	}

	public boolean isAdminRegister(Adminlogin al) {

		return admRepo.save(al) != null ? true : false;
	}

	public boolean isAddSubject(Subject sub) {
		return subRepo.save(sub) != null ? true : false;
	}

	public List<Student> getAllStudentdata() {
		list = studRepo.findAll();
		return list;
	}

	public Mark saveMark(Mark mark) {
		return markRepository.save(mark);
	}
	
	public Mark getMarkById(Mark mark) {
		Optional<Mark> o=markRepository.findById(mark.getMarkId());
		System.out.println(o);
		return o.isPresent()?o.get():null;
	}
	
	//find username and password admin
	public Adminlogin authenticate(String username,String password) {
		return admRepo.findAdminUsernameandpass(username, password);
	}
	
	public List<Adminlogin> getAdminUserpass(){
		return admRepo.findAll();
	}
	
	//find student username and password
	public Student authenticatestudent(String username,String password) {
		
		Student s = studRepo.findStudentuserpass(username, password);
		System.out.println(s.getUsername());
		System.out.println(s.getPassword());
		System.out.println(s.getSid());
		return s;
	}
	
	public List<Student> getStudentUserPass(){
		return studRepo.findAll();
	}
	
	
	
}
