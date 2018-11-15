package com.cg.springmvcone.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.cg.springmvcone.dto.Employee;
import com.cg.springmvcone.service.IServiceEmployee;



@Controller
public class MyController {
	
	@Autowired
	IServiceEmployee employeeservice;
	
	@RequestMapping(value="all",method=RequestMethod.GET)
	public String getAll(){
		return "home";
		
	}
	
	@RequestMapping(value="add", method=RequestMethod.GET)
	public String addEmployee(@ModelAttribute("my") Employee emp, Map<String, Object> model){
	
		List<String> myDeg = new ArrayList<>();
		myDeg.add("Software Engg");
		myDeg.add("Sr Consultant");
		myDeg.add("Manager");
		model.put("deg",myDeg);
		return "addemployee";
		
	}
	
	@RequestMapping(value="insertdata",method=RequestMethod.POST)
	public ModelAndView insertEmployee(@Valid@ModelAttribute("my") Employee emp,BindingResult result,Map<String, Object> model){
		
		int id=0;
		if(result.hasErrors()){
			System.out.println("Hi from if");
			List<String> myDeg = new ArrayList<String>();
			myDeg.add("Software Engg");
			myDeg.add("Sr Consultant");
			myDeg.add("Manager");
			model.put("deg",myDeg);
			return  new ModelAndView("addemployee");	
		}
		else{
			System.out.println("Hi from else");
			id=employeeservice.addEmployeeData(emp);
		}
		return  new ModelAndView("sucess","edata",id);
		
	}
	
	@RequestMapping(value="show",method=RequestMethod.GET)
	public ModelAndView showAllEmployee(){
		
		List<Employee> myAllData = employeeservice.showAllEmployee();
		return new ModelAndView("showall","temp",myAllData);
		
	}
	
	@RequestMapping(value="delete",method=RequestMethod.GET)
	public String deleteEmployee(){
		return "deleteemployee";
	}
	
	@RequestMapping(value="dodelete",method=RequestMethod.GET)
	public String employeeDelete(@RequestParam("eid") int id){
		employeeservice.deleteEmployee(id);
		return "sucess";
	}
	
	@RequestMapping(value="search",method=RequestMethod.GET)
	public String searchEmployee(){
		return "updateemployee";
	}
	@RequestMapping(value="dosearch",method=RequestMethod.GET)
	public String employeeSearch(@RequestParam("eid") int id){
		Employee emp =employeeservice.searchEmployee(id);
		System.out.println(emp);
		return "sucess";
	}
	
	public String employeeUpdate(@RequestParam("eid") int id){
		Employee emp =employeeservice.searchEmployee(id);
		
		return null;
	}

}
