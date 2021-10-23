package com.yash.mba.domain;

import java.util.Set;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "theatre")
public class Theatre {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "theatre_id")
  private Long id;

  @Column(name = "name")
  private String name;
  
  
  @Column(name = "city")
  private String city;

  
  
//  @OneToMany(mappedBy = "theatre", cascade = CascadeType.ALL)
//  @JsonBackReference
//  private Set<Auditorium> auditoriums;

public Long getId() {
	return id;
}

public void setId(Long id) {
	this.id = id;
}

public String getName() {
	return name;
}

public void setName(String name) {
	this.name = name;
}


//public Set<Auditorium> getAuditoriums() {
//	return auditoriums;
//}
//
//public void setAuditoriums(Set<Auditorium> auditoriums) {
//	this.auditoriums = auditoriums;
//}

public String getCity() {
	return city;
}

public void setCity(String city) {
	this.city = city;
}


@Override
public String toString() {
	return "Theatre [id=" + id + ", name=" + name + ", city=" + city + "]";
}

public Theatre() {
	super();
	// TODO Auto-generated constructor stub
}

}