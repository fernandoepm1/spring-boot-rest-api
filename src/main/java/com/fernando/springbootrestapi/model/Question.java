package com.fernando.springbootrestapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

@Entity
@Table(name = "questions")
public class Question extends AuditModel {

	@GeneratedValue(generator = "question_generator")
	@SequenceGenerator(name = "question_generator", sequenceName = "question_sequence", initialValue = 1000)
	@Id
	private Long id;

	@Size(min = 3, max = 100)
	@NotBlank
	private String title;

	@Column(columnDefinition = "text")
	private String description;

	// Constructor
	public Question(Long id, String title, String description) {
		this.id = id;
		this.title = title;
		this.description = description;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", title='" + getTitle() + "'" +
			", description='" + getDescription() + "'" +
			"}";
	}
}
