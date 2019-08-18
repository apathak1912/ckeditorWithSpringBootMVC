package com.example.editor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.editor.module.CkEditorModule;
import com.example.editor.repository.CKEditorrepository;

@Service
@Transactional
public class CKEditorServiceImpl implements CKEditorService {

	@Autowired
	CKEditorrepository ckerepo;
	
	@Override
	public void createUser(CkEditorModule ckeditormodule) {
		// TODO Auto-generated method stub
		ckerepo.save(ckeditormodule);

	}

	@Override
	public List<CkEditorModule> getUser() {
		// TODO Auto-generated method stub
		return (List<CkEditorModule>) ckerepo.findAll();
	}

	@Override
	public CkEditorModule findById(long id) {
		// TODO Auto-generated method stub
		
		return ckerepo.findOne(id);
	}

	@Override
	public CkEditorModule update(CkEditorModule ckeditormodule, long l) {
		// TODO Auto-generated method stub
		return ckerepo.save(ckeditormodule);
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub
		ckerepo.delete(id);

	}

}
