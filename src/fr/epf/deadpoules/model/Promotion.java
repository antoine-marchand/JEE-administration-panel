package fr.epf.deadpoules.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

import com.sun.istack.internal.NotNull;

@Entity
public class Promotion {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotNull
	private String name;
	
	@OneToMany(mappedBy="promotion")
	private List<Member> members;
	
	@OneToMany(mappedBy="promotion")
	private List<CodeReview> codeReviews;
	
	public Promotion() {}
	
	public Promotion(String name) {
		this.name = name;
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
