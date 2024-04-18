package com.Example.ToDoListDemonstration.Controller;

import java.util.List;

import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
	public String showLists(Model theModel)
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
		return "redirect:/api/showList";
	}
	@GetMapping("/deleteItem")
	public String deleteItem(@RequestParam("id")int id)
	{
		theServiceInterface.delete(id);
		return "redirect:/api/showList";
	}

}
