package com.bridgeit.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.bridgeit.project.dto.ActorDTO;
import com.bridgeit.project.response.Response;
import com.bridgeit.project.service.ActorService;

@RestController
@RequestMapping("/actorcontroller")

public class ActorController {

	@Autowired
	private ActorService actorService;
	@PostMapping("/createactor")
	public ResponseEntity<Response> createActor(@RequestBody ActorDTO actordto){
		System.out.println("in controller");
		Response response = actorService.createActor(actordto);
		System.out.println(response);
		return new ResponseEntity<>(response, HttpStatus.OK);

	}
	
}
