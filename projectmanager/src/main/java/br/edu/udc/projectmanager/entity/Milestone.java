package br.edu.udc.projectmanager.entity;

import java.util.Calendar;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;

@Entity
public class Milestone extends AbstractEntity {
	
	@NotNull
	@Column( nullable = false, unique = true, length = 50 )
	private String name;
	
	@Column ( length = 200 )
	private String notes;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar initialDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	private Calendar finalDate;
	
	@ManyToOne( optional = false )
	private Project project;

	public Milestone() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Milestone(Long id) {
		super(id);
		// TODO Auto-generated constructor stub
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNotes() {
		return notes;
	}

	public void setNotes(String notes) {
		this.notes = notes;
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

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	
}
