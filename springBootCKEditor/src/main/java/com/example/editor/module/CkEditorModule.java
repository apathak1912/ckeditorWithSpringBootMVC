package com.example.editor.module;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@Entity
@Table(name="CkeData")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CkEditorModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	public String editor1;

	public String geteditor1() {
		return editor1;
	}

	public void seteditor1(String cKEditor) {
		editor1 = cKEditor;
	}
}
