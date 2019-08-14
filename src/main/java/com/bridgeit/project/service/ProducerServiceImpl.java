package com.bridgeit.project.service;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.bridgeit.project.dto.ProducerDTO;
import com.bridgeit.project.model.Producer;
import com.bridgeit.project.repository.ProducerRepository;
import com.bridgeit.project.response.Response;

@Service
public class ProducerServiceImpl implements ProducerService {
	//@Autowired
	//private ModelMapper modelMapper;
	
	@Autowired
	private ProducerRepository producerRepository;
	public Response createProducer(ProducerDTO producerdto)
	{
		System.out.println(producerdto.getDOB());
		ModelMapper modelMapper=new ModelMapper();
		Producer producer= modelMapper.map(producerdto,Producer.class);
		producerRepository.save(producer);
		Response response = ResponseHelper.statusResponse(100,"create producer");
		return response;
    }
}
