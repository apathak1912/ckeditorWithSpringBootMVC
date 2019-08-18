package com.example.editor.service;

import java.util.List;

import com.example.editor.module.CkEditorModule;



public interface CKEditorService {
	
	public void createUser(CkEditorModule ckeditormodule);
	public List<CkEditorModule> getUser();
	public CkEditorModule findById(long id);
	public CkEditorModule update(CkEditorModule ckeditormodule, long l);
	public void deleteUserById(long id);

}
