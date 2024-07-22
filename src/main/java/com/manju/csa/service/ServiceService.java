package com.manju.csa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.manju.csa.requestDto.ServiceRequestDto;
import com.manju.csa.responseDto.ServiceResponseDto;
import com.manju.csa.utility.ResponseStructure;

public interface ServiceService {

	public ResponseEntity<ResponseStructure<ServiceResponseDto>> addService(ServiceRequestDto serviceRequestDto);

	public ResponseEntity<ResponseStructure<ServiceResponseDto>> findByserviceId(int serviceId);

	public ResponseEntity<ResponseStructure<List<ServiceResponseDto>>> findAllService();
	
	public ResponseEntity<ResponseStructure<ServiceResponseDto>> updateByServiceId(int serviceId, ServiceRequestDto updateServiceRequest);

	public ResponseEntity<ResponseStructure<ServiceResponseDto>> deleteByServiceId(int serviceId);


}
