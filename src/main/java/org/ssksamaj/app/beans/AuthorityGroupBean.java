package org.ssksamaj.app.beans;

import java.io.Serializable;
import java.time.LocalDateTime;

public class AuthorityGroupBean implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer id;
	private String groupname;
	private String description;
	private LocalDateTime lastUpdated;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getGroupname() {
		return groupname;
	}
	public void setGroupname(String groupname) {
		this.groupname = groupname;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public LocalDateTime getLastUpdated() {
		return lastUpdated;
	}
	public void setLastUpdated(LocalDateTime lastUpdated) {
		this.lastUpdated = lastUpdated;
	}
}
