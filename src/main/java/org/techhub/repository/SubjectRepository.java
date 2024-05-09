package org.techhub.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import org.techhub.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject,Integer> {
	
}
