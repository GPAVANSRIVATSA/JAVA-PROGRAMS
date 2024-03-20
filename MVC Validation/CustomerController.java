package com.Validation.ValidationDemo.Controller;

import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Validation.ValidationDemo.Model.Customer;

import jakarta.validation.Valid;

@Controller
public class CustomerController {
	@InitBinder
	public void initBinder(WebDataBinder dataBinder)
	{
		StringTrimmerEditor stringTimmerEditor =new StringTrimmerEditor(true);
		dataBinder.registerCustomEditor(String.class,stringTimmerEditor);
	}
	@GetMapping("/showCustomerForm")
	public String showForm(Model model)
	{
		Customer cus = new Customer();
		model.addAttribute("customer",cus);
		return "customerForm";
	}
	@PostMapping("/processCustomerForm")
	public String processForm(@Valid @ModelAttribute("customer")Customer cus,BindingResult br)
	{
		if(br.hasErrors())
		{
			return "customerForm";
		}
		return "confirmationPage";
	}
	

}
