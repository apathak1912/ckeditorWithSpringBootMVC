package com.example.editor.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.editor.module.Description;
import com.example.editor.repository.Discriptionrepo;

@Service
@Transactional
public class DescriptionServiceImpl implements DescriptionService {

	@Autowired
	Discriptionrepo descriptionrepo;
	
	
	@Override
	public void createDescription(Description description) {
		// TODO Auto-generated method stub
		descriptionrepo.save(description);
		
	}


	@Override
	public List<Description> getAllDescription() {
		// TODO Auto-generated method stub
		System.out.println("ok");
		return descriptionrepo.findAllDescription();
	}


	@Override
	public int getDescriptionIdByDescription(String Description) {
		// TODO Auto-generated method stub
		return descriptionrepo.getDescriptionIdByDescription(Description);
	}

}
