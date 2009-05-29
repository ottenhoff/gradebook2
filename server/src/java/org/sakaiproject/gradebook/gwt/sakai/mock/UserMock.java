package org.sakaiproject.gradebook.gwt.sakai.mock;

import java.util.Stack;

import org.sakaiproject.entity.api.ResourceProperties;
import org.sakaiproject.time.api.Time;
import org.sakaiproject.user.api.User;
import org.w3c.dom.Document;
import org.w3c.dom.Element;


public class UserMock implements User {

	private String id;
	private String displayId;
	private String eid;
	private String firstName;
	private String lastName;
	private String email;
	
	public UserMock(String id, String displayId, String eid, String firstName, 
			String lastName, String email) {
		this.id = id;
		this.displayId = displayId;
		this.eid = eid;
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
	}
	
	public boolean checkPassword(String arg0) {
		// TODO Auto-generated method stub
		return false;
	}

	public User getCreatedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	public Time getCreatedTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getDisplayId() {
		return displayId;
	}

	public String getDisplayName() {
		return firstName + " " + lastName;
	}

	public String getEid() {
		return eid;
	}

	public String getEmail() {
		return email;
	}

	public String getFirstName() {
		return firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public User getModifiedBy() {
		// TODO Auto-generated method stub
		return null;
	}

	public Time getModifiedTime() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getSortName() {
		return lastName + ", " + firstName;
	}

	public String getType() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getId() {
		return id;
	}

	public ResourceProperties getProperties() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReference() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getReference(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUrl() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getUrl(String arg0) {
		// TODO Auto-generated method stub
		return null;
	}

	public Element toXml(Document arg0, Stack arg1) {
		// TODO Auto-generated method stub
		return null;
	}

	public int compareTo(Object o) {
		// TODO Auto-generated method stub
		return 0;
	}

	

}
