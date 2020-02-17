package com.fernando.springbootrestapi.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import javax.persistence.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

@Entity
@Table(name = "answers")
public class Answer extends AuditModel {

	@GeneratedValue(generator = "answer_generator")
	@SequenceGenerator(name = "answer_generator", sequenceName = "answer_sequence", initialValue = 1000)
	@Id
	private Long id;

	@Column(columnDefinition = "text")
	private String text;

	@ManyToOne(fetch = FetchType.LAZY, optional = false)
	@JoinColumn(name = "question_id", nullable = false)
	@OnDelete(action = OnDeleteAction.CASCADE)
	@JsonIgnore
	private Question question;

	// Constructor
	public Answer(Long id, String text, Question question) {
		this.id = id;
		this.text = text;
		this.question = question;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	@Override
	public String toString() {
		return "{" +
			" id='" + getId() + "'" +
			", text='" + getText() + "'" +
			", question='" + getQuestion() + "'" +
			"}";
	}
}
