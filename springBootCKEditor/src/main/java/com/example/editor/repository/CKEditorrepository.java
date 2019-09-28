package com.example.editor.repository;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.example.editor.module.CkEditorModule;

public interface CKEditorrepository extends CrudRepository<CkEditorModule, Long> {
	
	//@Query("SELECT cke FROM CkEditorModule cke where cke.description.id :id")
	@Query(value ="Select * from Cke_data where description_id = ?1", nativeQuery = true)
	CkEditorModule findCKEditorDataBydescid(int id);
	
	@Modifying
	@Transactional
	@Query(value ="Delete from Cke_data where description_id = ?1" , nativeQuery = true)
	void deleteCkedata(int id);
	
	

}
