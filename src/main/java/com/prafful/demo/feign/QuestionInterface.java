package com.prafful.demo.feign;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import com.prafful.demo.model.QuestionWrapper;
import com.prafful.demo.model.Response;

@FeignClient("QUESTION-SERVICE")
public interface QuestionInterface {
	@GetMapping("question/generate")
	public ResponseEntity<List<Integer>> getQuestionsForQuiz(@RequestParam String categoryName, @RequestParam int numQuestions);
	
	@PostMapping("question/getQuestons")
	public ResponseEntity<List<QuestionWrapper>> getQuestionsFromId(@RequestBody Integer question);
	
	@PostMapping("question/getScore")
	public ResponseEntity<Integer> getScore(@RequestBody List<Response> responses);

}
