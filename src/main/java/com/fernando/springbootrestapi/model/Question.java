package com.fernando.springbootrestapi.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Table(name = "questions")
@Data
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
}
