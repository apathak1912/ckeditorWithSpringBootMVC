package com.example.editor.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.editor.module.Signup;
import com.example.editor.repository.Signuprepository;

@Service
@Transactional
public class SignupServiceImpl implements SignupService {

	@Autowired
	Signuprepository signrepo;
	
	@Override
	public Signup createUser(Signup signup) {
		// TODO Auto-generated method stub
		return signrepo.save(signup);
	}

	@Override
	public List<Signup> getUser() {
		// TODO Auto-generated method stub
		
		return null;
	}

	@Override
	public Signup findById(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Signup update(Signup signup, long l) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteUserById(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public Signup findByEmail(String email) {
		return signrepo.findUserByEmail(email);
		
	}

}
