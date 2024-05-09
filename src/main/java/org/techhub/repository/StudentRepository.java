package org.techhub.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.techhub.model.Student;

@Repository("studRepo")
public interface StudentRepository extends JpaRepository<Student,Integer> {

	@Query("select a from Student a where a.username=:username and a.password=:password")
	Student findStudentuserpass(String username,String password);
	
}

