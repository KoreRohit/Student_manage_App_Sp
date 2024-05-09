package org.techhub.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.techhub.model.Mark;

public interface MarkRepository extends JpaRepository<Mark, Long> {
	
}
