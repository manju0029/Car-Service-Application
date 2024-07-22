package com.manju.csa.service;

import java.util.List;

import org.springframework.http.ResponseEntity;

import com.manju.csa.entity.Car;
import com.manju.csa.requestDto.CarRequestDto;
import com.manju.csa.responseDto.CarResponseDto;
import com.manju.csa.utility.ResponseStructure;

public interface CarService {
	
	
//	public Car addCar(Car car);
//	
//	public Car findByCarId(int carId);
	
	//ResponseEntity able to manipulate status heading
//	public ResponseEntity<ResponseStructure<Car>> addCar(Car car);
	
	public ResponseEntity<ResponseStructure<CarResponseDto>> addCar(CarRequestDto carRequestDto);
	//save collection of cars
//  	public ResponseEntity<ResponseStructure<List<CarResponseDto>>>  addCars (List<CarResponseDto> carResponseDtos );
	
//	public ResponseEntity<ResponseStructure<CarResponseDto>> addCars(CarRequestDto carRequestDto);

	public ResponseEntity<ResponseStructure<CarResponseDto>> findByCarId(int carId);
	
	public ResponseEntity<ResponseStructure<List<CarResponseDto>>> findAllCars();
	
	public ResponseEntity<ResponseStructure<CarResponseDto>> updateByCarId(int carId,CarRequestDto updatedCarRequest);
	
  	public ResponseEntity<ResponseStructure<CarResponseDto>> deleteByCarId(int carId);
	
  	
	
}
