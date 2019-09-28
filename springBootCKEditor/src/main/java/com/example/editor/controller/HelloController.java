package com.example.editor.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.example.editor.module.CkEditorModule;
import com.example.editor.module.Description;
import com.example.editor.module.Frontcontroller;
import com.example.editor.module.Frontcontrollerupdate;
import com.example.editor.module.Login;
import com.example.editor.module.Signup;
import com.example.editor.service.CKEditorService;
import com.example.editor.service.DescriptionService;
import com.example.editor.service.SignupService;


@Controller
public class HelloController {

   @Autowired
   CKEditorService ckeservices;
   
   @Autowired
   SignupService signupservice;
   
   @Autowired
   DescriptionService descriptionService;
   
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
   
   @PostMapping(value="/ckeditordata")///editckeditordata
   public @ResponseBody String ckEditorProcessing( Frontcontroller frontcontroller){
	   System.out.println(frontcontroller.getDescription()+" "+frontcontroller.getEditor1());
	   
	   Description desc = new Description();
	   desc.setDescription(frontcontroller.getDescription());
	   CkEditorModule ckem = new CkEditorModule();
	   ckem.setDescription(desc);
	   ckem.seteditor1(frontcontroller.getEditor1());
	   descriptionService.createDescription(desc);
	   ckeservices.createUser(ckem);
       return "Data Saved : " + ckem.editor1;
   }
   
   
   @PostMapping(value="/editckeditordata")//
   public @ResponseBody String ckEditorUpdateProcessing( Frontcontrollerupdate frontcontroller){
	  System.out.println("hhhhhhhhhhhhhhhhhhhh"+frontcontroller.getDescription());
	  System.out.println("hhhhhhhhhhhhhhhhhhhh"+frontcontroller.getEditor1());
	  
	   CkEditorModule ckem = ckeservices.findCKEditorDataBydescid(frontcontroller.getDescriptionid()); 
	   Description desc = descriptionService.getDescriptionByID(frontcontroller.getDescriptionid());
	   String existingDescription = desc.getDescription1();
	   String existingCkedata = ckem.geteditor1();
	   
	   if(!existingDescription.equals(frontcontroller.getDescription())) {
		   desc.setDescription(frontcontroller.getDescription());
		   descriptionService.createDescription(desc);
	   }
	   System.out.println(existingCkedata.equals(frontcontroller.getEditor1()));
	   
	   if(frontcontroller.getEditor1()!= null) {
		   if(!existingCkedata.equals(frontcontroller.getEditor1())) {
			   System.out.println("frontcontroller.getEditor1()"+frontcontroller.getEditor1());
			   ckem.seteditor1(frontcontroller.getEditor1());
			   ckeservices.createUser(ckem);
		   }
	   }else {
		   return "Data is null: "+ ckem.editor1;
	   }
	   return "Data Saved : "+ ckem.editor1;
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
   
   @GetMapping("/alldescription")
   public ModelAndView getDescription() {
	  ModelAndView model = new ModelAndView("/alldescription");
	  ArrayList<Description> inf = (ArrayList<Description>) descriptionService.getAllDescription();
	  model.addObject("inf", inf);
	   return model;
   }
   
   @GetMapping("/descriptionview/{id}")
   public ModelAndView getDecriptionView(@PathVariable("id") int id) {
	   String ckedata ;
	   ModelAndView model = new ModelAndView("/descriptionview");
		   System.out.println("id"+id);
		   ckedata = ckeservices.findCKEditorDataBydescid(id).editor1;
		    model.addObject("contenet",ckedata);
		    return model;
	
	   
	   
   }
   
   /*@GetMapping("/edit/{desc}")
   public ModelAndView doEdit(@PathVariable("desc") String desc) {
	   int id=0;
	   String ckedata ;
	   ModelAndView model = new ModelAndView("/editckeditor");
	   id = descriptionService.getDescriptionIdByDescription(desc);
	   //System.out.println("id"+id+" desc "+desc);
	   
		   //System.out.println("id"+id);
		   ckedata = ckeservices.findCKEditorDataBydescid(id).editor1;
		  // System.out.println("ckdeta"+ckedata);
		    model.addObject("econtenet",ckedata);
		    return model;
	   
	   
   }*/
   
   @GetMapping(value="/edit/{id}")
   public ModelAndView doEdit(@PathVariable("id") int id) {
	   String ckedata ;
	   ModelAndView model = new ModelAndView("/editckeditor");
	   ckedata = ckeservices.findCKEditorDataBydescid(id).editor1;
	   
	   //System.out.println("test"+descriptionService.getDescriptionByID(id).getDescription1());
	   model.addObject("edescriptionid",id);
	   model.addObject("eecontenet",ckedata);
	   model.addObject("edescription",descriptionService.getDescriptionByID(id).getDescription1());
	   System.err.println(descriptionService.getDescriptionByID(id).getDescription1());
	   return model;
	   
	   
   }
   
   @GetMapping(value="/delete/{id}")
   public void deleteNotes(@PathVariable("id") int id) {
	   try {
	   ckeservices.deleteCkeDataByDecID(id);
	   descriptionService.delDescriptionByID(id);
	   }catch (Exception e) {
		// TODO: handle exception
		   e.printStackTrace();
	   }
   }
   
   
   
}
