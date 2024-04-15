package com.List.ToDoListDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.List.ToDoListDemo.Service.ServiceInterface;
import com.List.ToDoListDemo.Things.ToDoThings;

@RestController
@RequestMapping("/api")
public class ListController {
	public ServiceInterface theServiceInterface;
	
	@Autowired
	public ListController(ServiceInterface theServiceInterface)
	{
		this.theServiceInterface=theServiceInterface;
	}
	@GetMapping("/listofthings")
	public String display(Model theModel)
	{
		List<ToDoThings>li=theServiceInterface.listThings();
		theModel.addAttribute("Thing",li);
		return "listThings";
	}
	@GetMapping("/showForm")
	public String showForm(Model theModel)
	{
		ToDoThings theToDoThings=new ToDoThings();
		theModel.addAttribute("theThing",theToDoThings);
		return "sendForm";
	}
	@PostMapping("/processForm")
	public String displayList(@ModelAttribute("theThing")ToDoThings theToDoThings)
	{
		theServiceInterface.add(theToDoThings);
		return "listThings";
	}
	@GetMapping("/deleteThing")
	public String deleteItem(@RequestParam("id")int id)
	{
		theServiceInterface.delete(id);
		return "listThings";
	}
}
