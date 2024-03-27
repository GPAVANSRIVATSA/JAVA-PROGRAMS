package com.MVCCrud.MVCCrudDemoApplication.Controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.MVCCrud.MVCCrudDemoApplication.Entity.Employee;
import com.MVCCrud.MVCCrudDemoApplication.Service.ServiceInterface;


@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	private ServiceInterface si;
	
	public EmployeeController(ServiceInterface se)
	{
		si=se;
	}
	@GetMapping("/list")
	public String listEmployees(Model model)
	{
		List<Employee>li=si.findAll();
		model.addAttribute("employees",li);
		return "listEmployees";
	}

}