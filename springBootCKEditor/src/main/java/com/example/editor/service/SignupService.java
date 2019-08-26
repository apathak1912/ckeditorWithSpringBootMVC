package com.example.editor.service;

import java.util.List;

import com.example.editor.module.Signup;


public interface SignupService {
	
	public Signup createUser(Signup signup);
	public Signup findByEmail(String email);
	public List<Signup> getUser();
	public Signup findById(long id);
	public Signup update(Signup signup, long l);
	public void deleteUserById(long id);
}
