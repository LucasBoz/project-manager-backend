package br.edu.udc.projectmanager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.edu.udc.projectmanager.entity.Activity;

public interface IActivityRepository extends JpaRepository<Activity, Long> {

	@Query(value = "SELECT new Activity( activity.id, activity.name, activity.description, activity.status, activity.project.id, activity.project.name, activity.user.id, activity.user.name ) "
			+ " FROM Activity activity")
	public List<Activity> qweqweqw();

	@Query(value = "SELECT new Activity( activity.id, activity.name, activity.description, activity.status, user, milestone) "
			 	   + " FROM Activity activity "
			 	   + " LEFT OUTER JOIN activity.milestone milestone"
			 	   + " LEFT OUTER JOIN activity.user user" 
	               + " WHERE activity.project.id = :projectId")
	public List<Activity> listActivityByProject(@Param("projectId") Long projectId);

}
