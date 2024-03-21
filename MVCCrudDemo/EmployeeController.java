package com.MVCCRUD.MVCCRUDDemo2.Controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.MVCCRUD.MVCCRUDDemo2.Entity.Employee;
import com.MVCCRUD.MVCCRUDDemo2.Service.ServiceInterface;
@Controller
@RequestMapping("/employees")
public class EmployeeController {
	
	ServiceInterface serviceInterface;
	@Autowired
	public EmployeeController(ServiceInterface si)
	{
		serviceInterface=si;
	}
	@GetMapping("/list")
	public String employeesList(Model model)
	{
		ArrayList<Employee>li=(ArrayList<Employee>) serviceInterface.findAll();
		model.addAttribute("employees",li);
		return "employees/listEmployees";
	}
	@GetMapping("/showFormForAdd")
	public String showForm(Model model)
	{
		Employee emp=new Employee();
		model.addAttribute("employee",emp);
		return "employees/employeeForm";
	}
	@GetMapping("/showFormForUpdate")
	public String update(@RequestParam("employeeId")int id,Model model)
	{
		Employee emp =serviceInterface.findById(id);
		model.addAttribute("employee",emp);
		return "employees/employeeForm";
	}
	@PostMapping("/save")
	public String save(@ModelAttribute("employee") Employee emp)
	{
		serviceInterface.add(emp);
		return "redirect:/employees/list";
	}
	@GetMapping("delete")
	public String delete(@RequestParam("employeeId")int id,Model model)
	{
		serviceInterface.delete(id);
		return "redirect:/employees/list";
	}
	

}
