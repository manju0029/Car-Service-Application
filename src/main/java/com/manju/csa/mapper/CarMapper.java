package com.manju.csa.mapper;


import org.springframework.stereotype.Component;

import com.manju.csa.entity.Car;
import com.manju.csa.requestDto.CarRequestDto;
import com.manju.csa.responseDto.CarResponseDto;

@Component
public class CarMapper {
	//CarMapper in this class we are mapping 1 obj into another object...

	public Car mapToCar(CarRequestDto carRequestdto)
	{
		Car car = new Car();
		car.setBrand(carRequestdto.getBrand());
		car.setModel(carRequestdto.getModel());
		return car;
	}

	public CarResponseDto mapToCarResponse(Car car)
	{
		CarResponseDto carResponseDto = new CarResponseDto();
		carResponseDto.setCarId(car.getCarId());
		carResponseDto.setBrand(car.getBrand());
		carResponseDto.setModel(car.getModel());
		return carResponseDto;
	}

}
