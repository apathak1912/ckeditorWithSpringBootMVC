package com.example.editor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.editor.module.CkEditorModule;
import com.example.editor.service.CKEditorService;


@Controller
public class HelloController {

   @Autowired
   CKEditorService ckeservices;
	
   @RequestMapping("/")
   public String ckEditor() {
      return "ckeditor";
   }
   
   @PostMapping(value="/ckeditordata")
   public @ResponseBody String ckEditorProcessing( CkEditorModule ckeditormodule){
	   System.out.println(ckeditormodule.editor1);
	   ckeservices.createUser(ckeditormodule);
       return "Data Saved : " + ckeditormodule.editor1;
   }
   
   
}
