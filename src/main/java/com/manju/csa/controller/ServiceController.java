package com.manju.csa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.manju.csa.mapper.ServiceMapper;
import com.manju.csa.requestDto.ServiceRequestDto;
import com.manju.csa.responseDto.ServiceResponseDto;
import com.manju.csa.service.ServiceService;
import com.manju.csa.utility.ResponseStructure;

@RestController
public class ServiceController {

	@Autowired
	private ServiceService serviceService;

	@Autowired
	private ServiceMapper serviceMapper;

	@PostMapping("/service")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> addService(@RequestBody ServiceRequestDto serviceRequestDto)
	{
		return serviceService.addService(serviceRequestDto);
	}
	
	@GetMapping("/service/{serviceId}")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> findByServiceId(@PathVariable int serviceId)
	{
		return serviceService.findByserviceId(serviceId);
	}

	@GetMapping("/service")
	public ResponseEntity<ResponseStructure<List<ServiceResponseDto>>> findAllService()
	{
		return serviceService.findAllService();
	}
	
	@PutMapping("/service/{serviceId}")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> updateByServiceId(@PathVariable int serviceId,@RequestBody ServiceRequestDto updateServiceRequest)
	{
		return serviceService.updateByServiceId(serviceId, updateServiceRequest);
	}
	
	
	@DeleteMapping("/service/{serviceId}")
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> deleteByServiceId(@PathVariable int serviceId)
	{
		return serviceService.deleteByServiceId(serviceId);
	}

}
