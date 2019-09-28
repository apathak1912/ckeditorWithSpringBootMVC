package com.example.editor.repository;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.editor.module.Description;
import com.example.editor.module.Signup;

public interface Discriptionrepo extends JpaRepository<Description, Long> {
	
	@Query("SELECT d FROM Description d")
	List<Description> findAllDescription();
	
	@Query("SELECT d.id FROM Description d where d.Description1  = ?1")
	int getDescriptionIdByDescription(String Description);
	
	
	@Query("SELECT d FROM Description d where d.id  = ?1")
	Description getDescriptionById(int id);
	
	/*
	 * @Query("SELECT u FROM Signup u WHERE u.email = ?1")
	Signup findUserByEmail(String Email);
	 * */
	
	@Modifying
	@Transactional
	@Query("Delete FROM Description d Where d.id = ?1")
	void deleteDescription(int id);

}
