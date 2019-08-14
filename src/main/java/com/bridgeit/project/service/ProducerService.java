package com.bridgeit.project.service;

import javax.validation.Valid;

import com.bridgeit.project.dto.ProducerDTO;
import com.bridgeit.project.response.Response;

public interface ProducerService {

	Response createProducer(@Valid ProducerDTO producerdto);

}
