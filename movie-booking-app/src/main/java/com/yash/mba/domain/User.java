package com.yash.mba.domain;


import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

//import lombok.Getter;
//import lombok.NoArgsConstructor;
//import lombok.Setter;

@Entity
@Table(name="user")
public class User {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
@Column(name="user_id")
private Long id;

@Column(name = "user_name")
private String userName;

@Column(name = "password")
private String password;



public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getUserName() {
	return userName;
}

public void setUserName(String userName) {
	this.userName = userName;
}

public String getPassword() {
	return password;
}

public void setPassword(String password) {
	this.password = password;
}



public User() {
	super();
	// TODO Auto-generated constructor stub
}

@Override
public String toString() {
	return "User [id=" + id + ", userName=" + userName + ", password=" + password + "]";
}


}
