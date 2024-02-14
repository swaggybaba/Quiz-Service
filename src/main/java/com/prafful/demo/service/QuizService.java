package com.prafful.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.prafful.demo.model.QuestionWrapper;
import com.prafful.demo.dao.QuizDao;
import com.prafful.demo.feign.QuestionInterface;
import com.prafful.demo.model.Quiz;
import com.prafful.demo.model.Response;

@Service
public class QuizService {

	@Autowired
	QuizDao quizDao;

	@Autowired
	QuestionInterface questionInterface;
	
	public ResponseEntity<String> createQuiz(String category, int numQ, String title) {
		List<Integer> questions = questionInterface.getQuestionsForQuiz(category, numQ).getBody();
		Quiz quiz =new Quiz();
		quiz.setTitle(title);
		quiz.setQuestionIds(questions);
		quizDao.save(quiz);
		return new ResponseEntity<>("success",HttpStatus.OK);
	}

	public ResponseEntity<List<QuestionWrapper>> getQuizQuestions(Integer id) {
		Quiz quiz = quizDao.findById(id).get();
		List<QuestionWrapper> resultList = questionInterface.getQuestionsFromId(id).getBody();
		return new ResponseEntity<>(resultList,HttpStatus.OK);
	}

	public ResponseEntity<Integer> calculate(Integer id, List<Response> responses) {
		
		int right=questionInterface.getScore(responses).getBody();
		return new ResponseEntity<>(right,HttpStatus.OK);
	}
}
