package com.example.editor.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Description")
public class Description {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "description_id")
	int id;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescription1() {
		return Description1;
	}

	public void setDescription(String description) {
		Description1 = description;
	}

	/*public CkEditorModule getCkEditorModule() {
		return CkEditorModule;
	}*/

	/*public void setCkEditorModule(CkEditorModule ckem) {
		this.CkEditorModule = ckem;
	}*/

	@Column(length=600,name = "Description")
	private String Description1;
	
	/*@OneToOne(fetch = FetchType.LAZY,cascade =  CascadeType.ALL,mappedBy = "Description")
	private CkEditorModule CkEditorModule;*/

}
