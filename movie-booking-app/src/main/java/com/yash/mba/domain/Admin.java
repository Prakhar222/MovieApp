package com.yash.mba.domain;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;


@Entity
@Table(name="admin")
//Class Declared
public class Admin {
	
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="admin_id")
private Long id;

@Column(name = "admin_name")
private String adminName;

@Column(name = "admin_email")
private String adminEmail;


@Column(name = "password")
private String password;


public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getAdminName() {
	return adminName;
}

public void setAdminName(String adminName) {
	this.adminName = adminName;
}

public String getAdminEmail() {
	return adminEmail;
}

public void setAdminEmail(String adminEmail) {
	this.adminEmail = adminEmail;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



@Override
public String toString() {
	return "Admin [id=" + id + ", adminName=" + adminName + ", adminEmail=" + adminEmail + ", password=" + password
			+ "]";
}

public Admin() {
	super();
	// TODO Auto-generated constructor stub
}

}
