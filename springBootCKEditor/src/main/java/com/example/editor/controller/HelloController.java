package com.example.editor.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.editor.module.CkEditorModule;
import com.example.editor.module.Login;
import com.example.editor.module.Signup;
import com.example.editor.service.CKEditorService;
import com.example.editor.service.SignupService;


@Controller
public class HelloController {

   @Autowired
   CKEditorService ckeservices;
   
   @Autowired
   SignupService signupservice;
   
   @RequestMapping("/signup")
   public String signUp() {
      return "signup";
   }
   
   @RequestMapping("/login")
   public String logIn() {
      return "login";
   }
	
   /*@PostMapping(path ="/validate")
   public ResponseEntity<String> validate(Login login){
	  
	   if(login.getEmail() != null) {
		   Signup user =  signupservice.findByEmail(login.getEmail());
			 if(user != null) {
				 System.out.println(user.getName()+" "+user.getPassword()+"login "+login.getPassword());
				 //int i =;
				 if(login.getPassword().equals(user.getPassword())) {
					 return new ResponseEntity<String>("Welcome ."+user.getName(),HttpStatus.OK);
				 }else {
					 return new ResponseEntity<String>("Wrong Password",HttpStatus.BAD_REQUEST);
				 }
			 }else {
			   return new ResponseEntity<String>("this email doesnot exists .",HttpStatus.BAD_REQUEST);
			 }
		   }
	   else {
		   return new ResponseEntity<String>("this email doesnot exists .",HttpStatus.BAD_REQUEST);
	   }
		   //return new ResponseEntity<String>("",HttpStatus.OK);
   }*/
   
   @PostMapping(path ="/validate")
   public String validate(Login login){
	  
	   if(login.getEmail() != null) {
		   Signup user =  signupservice.findByEmail(login.getEmail());
			 if(user != null) {
				 System.out.println(user.getName()+" "+user.getPassword()+"login "+login.getPassword());
				 
				 if(login.getPassword().equals(user.getPassword())) {
					 return "ckeditor";
				 }
			 }
		   }
	   
	   return "";
	   
		   //return new ResponseEntity<String>("",HttpStatus.OK);
   }
   
   
   @RequestMapping("/cke")
   public String ckEditor() {
      return "ckeditor";
   }
   
   @PostMapping(value="/ckeditordata")
   public @ResponseBody String ckEditorProcessing( CkEditorModule ckeditormodule){
	   System.out.println(ckeditormodule.editor1);
	   ckeservices.createUser(ckeditormodule);
       return "Data Saved : " + ckeditormodule.editor1;
   }
   
   @PostMapping(value="/users")
   public ResponseEntity<String> userProcessing( Signup signup){
	   
	   Signup sign = signupservice.createUser(signup);
	   
	   if (sign!= null) {
		   return new ResponseEntity<String>(signup.getUsername(),HttpStatus.OK);
	   }else {
		   return new ResponseEntity<String>("Data couldnot saved",HttpStatus.BAD_GATEWAY);
	   }
   }
   
   
   
   
}
