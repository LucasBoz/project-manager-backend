package br.edu.udc.projectmanager.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Project extends AbstractEntity {
	
	@NotNull
	@Column( nullable = false, length = 50, unique = true )
	private String name;
	
	@Column( nullable = true )
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar initialDate;
	
	@Column( nullable = true )
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar finalDate;
	
	@Column( nullable=false )
	@Enumerated(EnumType.ORDINAL)
	private ProjectStatus status;
	
	@NotNull
	@ManyToOne( fetch = FetchType.EAGER )
	private User projectManager;
	
	@ManyToMany( fetch = FetchType.EAGER )
	private Set<User> members = new HashSet<User>();
	
	public Project() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Project(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}
	/**
	 * 
	 * @param id
	 * @param name
	 * @param initialDate
	 * @param finalDate
	 * @param status
	 * @param projectManagerId
	 * @param projectManagerName
	 */
	public Project ( Long id, String name, Calendar initialDate, Calendar finalDate, ProjectStatus status, Long projectManagerId, String projectManagerName)
	{
		 super ( id );
		 this.name = name;
		 this.initialDate = initialDate;
		 this.finalDate = finalDate;
		 this.status = status;

		 User user = new User();
		 user.setId( projectManagerId );
		 user.setName( projectManagerName );

		 this.setProjectManager( user );
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Calendar getInitialDate() {
		return initialDate;
	}

	public void setInitialDate(Calendar initialDate) {
		this.initialDate = initialDate;
	}

	public Calendar getFinalDate() {
		return finalDate;
	}

	public void setFinalDate(Calendar finalDate) {
		this.finalDate = finalDate;
	}

	public ProjectStatus getStatus() {
		return status;
	}

	public void setStatus(ProjectStatus status) {
		this.status = status;
	}

	public User getProjectManager() {
		return projectManager;
	}

	public void setProjectManager(User projectManager) {
		this.projectManager = projectManager;
	}

	public Set<User> getMembers() {
		return members;
	}

	public void setMembers(Set<User> members) {
		this.members = members;
	}

	
	
	
}
