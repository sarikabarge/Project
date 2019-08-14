package com.bridgeit.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgeit.project.dto.ActorDTO;
import com.bridgeit.project.model.Actor;
import com.bridgeit.project.repository.ActorRepository;
import com.bridgeit.project.response.Response;

@Service
public class ActorServiceImpl implements ActorService {

	@Autowired
	private ActorRepository actorRepository;
	
	@Override
		public Response createActor(ActorDTO actordto)
	{
	        ModelMapper modelMapper=new ModelMapper();
	     Actor actor=modelMapper.map(actordto,Actor.class);
	     actorRepository.save(actor);
	     Response response = ResponseHelper.statusResponse(100,"create actor");
			return response;
	}

}
