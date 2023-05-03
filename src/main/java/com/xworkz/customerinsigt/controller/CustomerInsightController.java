package com.xworkz.customerinsigt.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.xworkz.customerinsigt.dto.CustomerInsightDto;
import com.xworkz.customerinsigt.entity.CustomerInsightEntity;
import com.xworkz.customerinsigt.service.CustomerInsightService;
@Controller
@RequestMapping("/")
public class CustomerInsightController {
	
	@Autowired
	private CustomerInsightService service;
	
	public CustomerInsightController() {
		System.out.println("Create" + this.getClass().getSimpleName());
	}
	@RequestMapping(value ="/save")
	public String save(CustomerInsightDto dto,Model model) {
	System.out.println("Save method running");
	System.out.println(dto);
	boolean status = service.save(dto,model);
	if(status) {
		model.addAttribute("Result","Data is saved Successfully");
		return "SingUp";
	}
	model.addAttribute("Result1","Data is not saved");
	return "SingUp";	
		
	}
	@RequestMapping(value ="/signin")
	public String findByEmailAndPassword(@RequestParam("email")String email,@RequestParam("password")String password ,Model model) {
	CustomerInsightEntity entity = service.findByEmailAndPassword(email, password, model);
	if(entity!=null) {
		model.addAttribute("login","Log in");
		return "WellCome";
	}else {
		System.out.println("logedIn faild");
		model.addAttribute("wrongCredentials","wrongpassword entered recheck your password");
		return "SingIn";
	}
	}
    @RequestMapping(value="/Forgotpassword")
	public String forgotPassword(String email,CustomerInsightEntity entity,Model model) {
    	System.out.println(email);
    	if (email != null) {
		String status = service.forgotPassword(email);
		if(status!=null) {
			model.addAttribute("EmailInput",status);
		
		System.out.println(status);
			model.addAttribute("msg", "otp is sent to your email");
	
			return "GetOtp";
		} else {
			return "ForgotPassword";
		}	
	}
		return null;
    }
@RequestMapping(value="/validateOtp")
public String validateOtp(int otp,String email,Model model) {
	System.out.println("otp is comming");
	if(email!=null) {
	boolean stu = service.validateOtpByEmail(otp, email);
	System.out.println(stu);
	System.out.println(otp);
	System.out.println(email);
	model.addAttribute("otp","otp validate successfully");
	return "ResetPassword";
	}
	model.addAttribute("wrong","You have enter wrong otp please check again");
	return "GetOtp";	
}
@RequestMapping(value="/ResetPassword")
public String resetPassword(String email,String password,String confirmPassword,Model model) {
    if(email!=null && password!=null) {
    boolean stu = service.resetPassword(email, password, confirmPassword);	
    System.out.println(email);
    System.out.println(password);
    System.out.println("Reset successfull");
    model.addAttribute("password","ResetPassword successfully");
    return "ResetPassword";
    }
    else {
    	model.addAttribute("wrongPass","wrongPassword entered Your password is not set");
    	return "ResetPassword";
    }
	
}
}