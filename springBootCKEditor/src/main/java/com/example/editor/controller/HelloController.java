package com.example.editor.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.editor.module.CkEditorModule;


@Controller
public class HelloController {

   @RequestMapping("/")
   public String ckEditor() {
      return "ckeditor";
   }
   
   @PostMapping(value="/ckeditordata")
   public @ResponseBody String ckEditorProcessing( CkEditorModule ckeditormodule){
	   System.out.println(ckeditormodule.editor1);
       return "HELLO TEST : " + ckeditormodule;
   }
   
   
}
