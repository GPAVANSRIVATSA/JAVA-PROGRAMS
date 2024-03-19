package com.Thymeleaf.ThymeleafDemo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Thymeleaf.ThymeleafDemo.Model.Student;

@Controller
public class StudentController {
	@Value("${countries}")
	private List<String>countries;
	@Value("${favouriteProgrammingLanguage}")
	private List<String>favouriteProgrammingLanguage;
	@Value("${favouriteOS}")
	private List<String>favouriteOS;
	
	
	@GetMapping("/showStudentForm")
	public String showForm(Model model)
	{
		Student std=new Student();
		model.addAttribute("student",std);
		model.addAttribute("countries",countries);
		model.addAttribute("favouriteProgrammingLanguage",favouriteProgrammingLanguage);
		model.addAttribute("favouriteOS",favouriteOS);
		return "student-form";
	}
	@PostMapping("/processStudentForm")
	public String process(@ModelAttribute("student")Student std)
	{
		System.out.println("Student is "+std.getFirstName()+std.getLastName());
		return "confirmation-page";
	}

}
