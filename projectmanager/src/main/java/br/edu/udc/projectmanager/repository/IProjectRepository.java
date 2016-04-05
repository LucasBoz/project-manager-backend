package br.edu.udc.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.edu.udc.projectmanager.entity.Project;

public interface IProjectRepository extends JpaRepository<Project, Long> {
	@Query( value = "SELECT new Project( project.id, project.name, project.initialDate, project.finalDate, project.status, project.projectManager.id, project.projectManager.name) "
			+ " FROM Project project")
	public List<Project> find(); 
	
}
