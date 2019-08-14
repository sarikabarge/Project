package com.bridgeit.project.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bridgeit.project.dto.ProducerDTO;
import com.bridgeit.project.response.Response;
import com.bridgeit.project.service.ProducerService;

@RestController
@RequestMapping("/producerController")
public class ProducerController {

	@Autowired 
	private ProducerService producerService;
	@PostMapping("/registerProducer")
	public ResponseEntity<Response> register(@RequestBody ProducerDTO producerdto){
		System.out.println("in controller");
		Response response = producerService.createProducer(producerdto);
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
}
