package com.manju.csa.mapper;

import org.springframework.stereotype.Component;

import com.manju.csa.entity.Service;
import com.manju.csa.requestDto.ServiceRequestDto;
import com.manju.csa.responseDto.ServiceResponseDto;

@Component
public class ServiceMapper {


	public Service mapToService(ServiceRequestDto serviceRequestDto)
	{

		Service service = new Service();
		service.setServiceType(serviceRequestDto.getServiceType());
		service.setServiceCost(serviceRequestDto.getServiceCost());
		service.setDerscription(serviceRequestDto.getDescription());

		return service;
	}

	public ServiceResponseDto mapToServiceResponse(Service service)
	{
		ServiceResponseDto serviceResponseDto = new ServiceResponseDto();
		serviceResponseDto.setServiceId(service.getServiceId());
		serviceResponseDto.setServiceType(service.getServiceType());
		serviceResponseDto.setServiceCost(service.getServiceCost());
		serviceResponseDto.setDescription(service.getDerscription());

		return serviceResponseDto;

	}
}
