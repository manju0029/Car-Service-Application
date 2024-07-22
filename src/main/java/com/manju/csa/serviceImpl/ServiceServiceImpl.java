package com.manju.csa.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.management.RuntimeErrorException;
import javax.management.ServiceNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import com.manju.csa.entity.Service;
import com.manju.csa.mapper.ServiceMapper;
import com.manju.csa.repository.CarRepository;
import com.manju.csa.repository.ServiceRepository;
import com.manju.csa.requestDto.ServiceRequestDto;
import com.manju.csa.responseDto.ServiceResponseDto;
import com.manju.csa.service.ServiceService;
import com.manju.csa.utility.ResponseStructure;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements ServiceService {

	@Autowired
	private ServiceRepository serviceRepository;

	@Autowired
	private ServiceMapper serviceMapper;


	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> addService(ServiceRequestDto serviceRequestDto)
	{

		Service service = serviceMapper.mapToService(serviceRequestDto);
		service = serviceRepository.save(service);
		return 	 ResponseEntity
				.status(HttpStatus.CREATED)
				.body(new ResponseStructure<ServiceResponseDto>()
						.setStatusCode(HttpStatus.CREATED.value())
						.setMessage("Service Object found successfully!!")
						.setData(serviceMapper.mapToServiceResponse(service)));
	}

	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> findByserviceId(int serviceId) {
		return serviceRepository.findById(serviceId)
				.map(service -> ResponseEntity
						.status(HttpStatus.FOUND)
						.body(new ResponseStructure<ServiceResponseDto>()
								.setStatusCode(HttpStatus.FOUND.value())
								.setMessage("Service Object found successfully!!")
								.setData(serviceMapper.mapToServiceResponse(service))))
				.orElseThrow(() -> new RuntimeException("Failed to find service"));
	}


	@Override
	public ResponseEntity<ResponseStructure<List<ServiceResponseDto>>> findAllService() 
	{
		
		List<ServiceResponseDto> serviceResponseDtos = serviceRepository.findAll()
				.stream()       
				.map(service -> serviceMapper.mapToServiceResponse(service))
				.toList();

		ResponseStructure<List<ServiceResponseDto>> responseStructure = new ResponseStructure<List<ServiceResponseDto>>();

		responseStructure.setStatusCode(HttpStatus.FOUND.value());
		responseStructure.setMessage("Service object found successfully..");
		responseStructure.setData(serviceResponseDtos);

		return new ResponseEntity<ResponseStructure<List<ServiceResponseDto>>>(responseStructure, HttpStatus.FOUND);
	}


	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> updateByServiceId(int serviceId, ServiceRequestDto updateServiceRequest)
	{
		return  serviceRepository.findById(serviceId)
				.map( service ->  {
					Service  updateCar = serviceMapper.mapToService(updateServiceRequest);
					updateCar.setServiceId(service.getServiceId());
					serviceRepository.save(updateCar);

					return ResponseEntity
							.status(HttpStatus.FOUND)
							.body(new ResponseStructure<ServiceResponseDto>()
									.setStatusCode(HttpStatus.OK.value())
									.setMessage("Service Object update successfully.")
									.setData(serviceMapper.mapToServiceResponse(service)));		 	
				})
				.orElseThrow(() -> new RuntimeException("Service Not Found"));

	}

	@Override
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> deleteByServiceId(int serviceId) 
	{
		return  serviceRepository.findById(serviceId)
				.map(service -> {
					serviceRepository.delete(service);
					return   ResponseEntity
							.status(HttpStatus.OK)
							.body(new ResponseStructure<ServiceResponseDto>()
									.setStatusCode(HttpStatus.OK.value())
									.setMessage("Service Object Delete successfully.")
									.setData(serviceMapper.mapToServiceResponse(service)));
				})
				.orElseThrow(() -> new RuntimeException("Failed to delete service!!!"));
	}

}
