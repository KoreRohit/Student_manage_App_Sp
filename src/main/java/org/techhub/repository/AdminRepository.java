package org.techhub.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.techhub.model.Adminlogin;

public interface AdminRepository extends JpaRepository<Adminlogin,Integer> {
	@Query("select a from Adminlogin a where a.username=:username and a.password=:password")
	Adminlogin findAdminUsernameandpass(String username,String password);
}
