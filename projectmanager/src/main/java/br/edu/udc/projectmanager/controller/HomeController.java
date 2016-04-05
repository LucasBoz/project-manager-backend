package br.edu.udc.projectmanager.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import br.edu.udc.projectmanager.entity.Activity;
import br.edu.udc.projectmanager.entity.Project;
import br.edu.udc.projectmanager.repository.IActivityRepository;
import br.edu.udc.projectmanager.repository.IProjectRepository;

@Controller
@RestController
public class HomeController {
	
	@Autowired
	private IActivityRepository activityRepository;
	@Autowired
	private IProjectRepository projectRepository;
	
	
	@RequestMapping("/login")
	public ModelAndView home() 
	{
		return new ModelAndView("ui/index");
	}
	
	@RequestMapping("/")
	public ModelAndView menu()
	{
		return new ModelAndView("ui/index.html");
	}
	
	//FIXME teste de chamada Rest.
	@RequestMapping("/activityList")
	public List<Activity> activityList () {
		return  this.activityRepository.findAll();
	}
	@RequestMapping("/projectList")
	public List<Project> projectList () {
		return  this.projectRepository.findAll();
	}
	
}
