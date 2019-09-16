package com.example.editor.module;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.mysql.jdbc.Clob;

@Entity
@Table(name="CkeData")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class CkEditorModule {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	int id;
	
	/*
	 * @Column(length=60000) public String editor1;
	 */
	
	@Lob 
	public String editor1;
	
	@Transient
	public String Description;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "description_id", nullable = false)
	public Description description;
    
	public Description getDescription() {
		return description;
	}

	public void setDescription(Description description) {
		this.description = description;
	}

	public String geteditor1() {
		return editor1;
	}

	public void seteditor1(String cKEditor) {
		editor1 = cKEditor;
	}
}
