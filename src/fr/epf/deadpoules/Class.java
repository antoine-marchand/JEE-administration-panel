package fr.epf.deadpoules;

import java.util.List;

import javax.persistence.Basic;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Class {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String name;
	
	private List<Member> members;
	private List<CodeReview> codeReviews;
	
	
	public Class(String name) {
		super();
		this.name = name;
	}


	public Class() {
		super();
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}

	
	public List<Member> getMembers() {
		return members;
	}


	public void setMembers(List<Member> members) {
		this.members = members;
	}

	
	public List<CodeReview> getCodeReviews() {
		return codeReviews;
	}


	public void setCodeReviews(List<CodeReview> codeReviews) {
		this.codeReviews = codeReviews;
	}
	
	
	
	
	
	
}
