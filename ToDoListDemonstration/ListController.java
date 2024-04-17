package com.Example.ToDoListDemonstration.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.Example.ToDoListDemonstration.Entity.ListOfThings;
import com.Example.ToDoListDemonstration.Service.ServiceInterface;

@Controller
@RequestMapping("/api")
public class ListController {
	
	public ServiceInterface theServiceInterface;
	
	@Autowired
	public ListController(ServiceInterface theServiceInterface)
	{
		this.theServiceInterface=theServiceInterface;
	}
	@GetMapping("/showList")
	public String showList(Model theModel)
	{
		List<ListOfThings>li=theServiceInterface.listThings();
		theModel.addAttribute("Thing",li);
		return "itemsList";
	}
	@GetMapping("/showForm")
	public String displayForm(Model theModel)
	{
		ListOfThings theListOfThings=new ListOfThings();
		theModel.addAttribute("data",theListOfThings);
		return "addForm";
	}
	@PostMapping("/processForm")
	public String process(@ModelAttribute("data")ListOfThings theListOfThings)
	{
		theServiceInterface.add(theListOfThings);
		return "itemsList";
	}

}
