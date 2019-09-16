package com.example.editor.service;

import java.util.List;

import com.example.editor.module.Description;


public interface DescriptionService  {

	public void createDescription(Description dr);
	
	public List<Description> getAllDescription();
	
	public int getDescriptionIdByDescription(String Description);
}
