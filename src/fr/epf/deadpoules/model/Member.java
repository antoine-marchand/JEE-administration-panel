package fr.epf.deadpoules.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Member {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	private String email;
	private Date birthdate;

	public Member() {
	}	

	public Member(String name, String email, Date birthdate) {
		super();
		this.name = name;
		this.email = email;
		this.birthdate = birthdate;	
	}

public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getBirthdate() {
		return birthdate;
	}

	public void setBirthdate(Date birthdate) {
		this.birthdate = birthdate;
	}

		public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
