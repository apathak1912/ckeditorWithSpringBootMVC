package com.example.editor.repository;

import javax.persistence.Entity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.editor.module.Signup;

public interface Signuprepository extends JpaRepository<Signup,Long >{
	
	
	@Query("SELECT u FROM Signup u WHERE u.email = ?1")
	Signup findUserByEmail(String Email);
	
	/*@Entity
	@NamedQuery(name = "FindUserByEmail", query = "select U from Signup U where U.email = ?1");
	*/
}
