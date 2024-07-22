package com.manju.csa.serviceImpl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import com.manju.csa.entity.Car;
import com.manju.csa.exception.CarNotFoundException;
import com.manju.csa.mapper.CarMapper;
import com.manju.csa.repository.CarRepository;
import com.manju.csa.requestDto.CarRequestDto;
import com.manju.csa.responseDto.CarResponseDto;
import com.manju.csa.service.CarService;
import com.manju.csa.utility.ResponseStructure;

@Service
public class CarServiceImpl  implements CarService{

	@Autowired
	private CarRepository carRepository;

	@Autowired
	private CarMapper carMapper;

	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> addCar(CarRequestDto carRequestDto) 
	{
		//		Car car1 = carRepository.save(car);

		Car car = carMapper.mapToCar(carRequestDto);

		List<Car> list = new ArrayList<Car>();

		//		carRepository.save(car);

		carRepository.saveAll(list);


		CarResponseDto carResponseDto = carMapper.mapToCarResponse(car);

		ResponseStructure<CarResponseDto> responseStructure = new ResponseStructure<CarResponseDto>();

		responseStructure.setStatusCode(HttpStatus.CREATED.value());
		responseStructure.setMessage("Car Object created successfully");
		//		responseStructure.setData(carResponseDto);
		responseStructure.setData(carResponseDto);

		//		System.out.println("METHOS COME TO SERVICE"); FOR DEBUGGING PURPOSE
		return new ResponseEntity<ResponseStructure<CarResponseDto>>(responseStructure,HttpStatus.CREATED);
	}

	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> findByCarId(int carId) 
	{
		return	carRepository.findById(carId)
				.map(car -> ResponseEntity
				.status(HttpStatus.FOUND)
				.body(new ResponseStructure<CarResponseDto> ()
						.setStatusCode(HttpStatus.FOUND.value())
						.setMessage("Car object found successfully!!!")
						.setData(carMapper.mapToCarResponse(car))))
				.orElseThrow(() -> new CarNotFoundException("Failed to find car"));
	}

	@Override
	public ResponseEntity<ResponseStructure<List<CarResponseDto>>> findAllCars() 
	{
				List<CarResponseDto> carResponseDtos = carRepository.findAll()
						.stream()
						.map(car ->  carMapper.mapToCarResponse(car))
						.toList();
			ResponseStructure<List<CarResponseDto>>  responseStructure = new ResponseStructure<List<CarResponseDto>>();

			responseStructure.setStatusCode(HttpStatus.FOUND.value());
			responseStructure.setMessage("Car objects found successfully");
			responseStructure.setData(carResponseDtos);

			return new ResponseEntity<ResponseStructure<List<CarResponseDto>>>(responseStructure,HttpStatus.FOUND);
	}


	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> updateByCarId(int carId, CarRequestDto updatedCarRequest) 
	{

		return carRepository.findById(carId)
		.map(car -> {
			    Car  updateCar = carMapper.mapToCar(updatedCarRequest);
			    updateCar.setCarId(car.getCarId());
			    carRepository.save(updateCar);

			return ResponseEntity
					.status(HttpStatus.OK)
					.body(new ResponseStructure<CarResponseDto>()
							.setStatusCode(HttpStatus.OK.value())
							.setMessage("Car Object Update successfully")
							.setData(carMapper.mapToCarResponse(car)));
						})
			.orElseThrow(() -> new CarNotFoundException("Car not found"));
	}

	
	@Override
	public ResponseEntity<ResponseStructure<CarResponseDto>> deleteByCarId(int carId) 
	{
		 return   carRepository.findById(carId) 
		    .map(car -> {
		    carRepository.delete(car);
		    	 return ResponseEntity
		       		.status(HttpStatus.OK)
		    		.body(new ResponseStructure<CarResponseDto>()
		    				.setStatusCode(HttpStatus.OK.value())
		    				.setMessage("Car object deleted successfully")
		    				.setData(carMapper.mapToCarResponse(car)));
		    })
		    .orElseThrow(() -> new CarNotFoundException("Failed to delete"));
	}


	
	// Add List of Cars at time....
	//	@Override
	//	public ResponseEntity<ResponseStructure<List<CarResponseDto>>> addCars(List<CarResponseDto> carResponseDtos) {
	//	
	//		//		Car car1 = carRepository.save(car);
	//
	//		Car car = carMapper.mapToCar(carResponseDtos);
	//
	//		List<CarResponseDto> list = new ArrayList<CarResponseDto>();
	//		
	////		carRepository.save(car);
	//		
	//		carRepository.saveAll(list);
	//		
	//
	//		CarResponseDto carResponseDto = carMapper.mapToCarResponse(car);
	//
	//		ResponseStructure<List<CarResponseDto>> responseStructure = new ResponseStructure<List<CarResponseDto>>();
	//
	//		responseStructure.setStatusCode(HttpStatus.CREATED.value());
	//		responseStructure.setMessage("Car Object created successfully");
	////		responseStructure.setData(carResponseDto);
	//		responseStructure.setData(carResponseDtos);
	//
	//		//		System.out.println("METHOS COME TO SERVICE"); FOR DEBUGGING PURPOSE
	//		return new ResponseEntity<ResponseStructure<List<CarResponseDto>>>(responseStructure,HttpStatus.CREATED);
	//	}



}

