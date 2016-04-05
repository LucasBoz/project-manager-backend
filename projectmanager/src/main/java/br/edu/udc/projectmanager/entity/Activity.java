package br.edu.udc.projectmanager.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotNull;

@Entity
public class Activity extends AbstractEntity {
	
	/**
	 * 
	 */
	@NotNull
	@Column( nullable = true, length = 50 )
	private String name;
	
	/**
	 * 
	 */
	@Column( length = 200 )
	private String description;
	
	/**
	 * 
	 */
	private boolean status;
	
	/**
	 * 
	 */
	@ManyToOne( optional = true, fetch = FetchType.EAGER )
	private User owner;
	
	/**
	 * 
	 */
	@ManyToOne ( optional = false, fetch = FetchType.EAGER )
	private Project project;
	
	@OneToMany ( cascade = CascadeType.REMOVE, mappedBy="activity", fetch = FetchType.EAGER)
	private Set<ActivityLog> activityLog = new HashSet<ActivityLog>();
	
	@OneToMany ( cascade = CascadeType.REMOVE, mappedBy="activity", fetch = FetchType.EAGER)
	private Set<Annotation> annotations = new HashSet<Annotation>();
	/**
	 * 
	 */
	public Activity()
	{
		super();
	}
	
	/**
	 * 
	 * @param id
	 */
	public Activity( Long id )
	{
		super( id );
	}

	/**
	 * 
	 */
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result
				+ ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (status ? 1231 : 1237);
		return result;
	}

	/**
	 * 
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Activity other = (Activity) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (status != other.status)
			return false;
		return true;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public boolean isStatus() {
		return status;
	}

	public void setStatus(boolean status) {
		this.status = status;
	}

	public User getOwner() {
		return owner;
	}

	public void setOwner(User owner) {
		this.owner = owner;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public Set<ActivityLog> getActivityLog() {
		return activityLog;
	}

	public void setActivityLog(Set<ActivityLog> activityLog) {
		this.activityLog = activityLog;
	}

	public Set<Annotation> getAnnotations() {
		return annotations;
	}

	public void setAnnotations(Set<Annotation> annotations) {
		this.annotations = annotations;
	}
	
	

}
