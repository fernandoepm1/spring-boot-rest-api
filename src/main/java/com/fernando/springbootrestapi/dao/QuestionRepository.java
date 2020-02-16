package com.fernando.springbootrestapi.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.fernando.springbootrestapi.model.Question;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

}
