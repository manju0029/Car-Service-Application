package com.manju.csa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.manju.csa.entity.Car;
import com.manju.csa.mapper.CarMapper;
import com.manju.csa.requestDto.CarRequestDto;
import com.manju.csa.responseDto.CarResponseDto;
import com.manju.csa.service.CarService;
import com.manju.csa.utility.ResponseStructure;


@RestController
//@Controller 
//@ResponseBody

public class CarController {

	@Autowired
	private CarService carService;

	@Autowired
	private CarMapper carMapper;


	//	@GetMapping("/car/findByCarId")
	//	@GetMapping("/car/{carId}")
	//	public ResponseEntity<ResponseStructure<Car>> findByCarId(@RequestParam int carId) 
	//	{
	//		return carService.findByCarId(carId);
	//	}
	//	
	//	@PutMapping("/car/{carId}")
	//	public ResponseEntity<ResponseStructure<Car>> updateByCarId( @PathVariable int carId, @RequestBody Car updatedCar)
	//	{
	//		return carService.updateByCarId(carId, updatedCar);
	//		
	//	}
	//	
	//	@GetMapping("/car")
	//	public ResponseEntity<ResponseStructure<List<Car>>> findAllCar(Car car)
	//	{
	//		return carService.findAllCar();
	//	}
	//	
	//	@DeleteMapping("/car/{carId}")
	//   public ResponseEntity<ResponseStructure<Car>> deleteByCarId(@RequestParam int carId)
	//   {
	//	   return carService.deleteByCarId(carId);
	//   }
	//	
	//	
	//	@PostMapping("/car/mapToCar")
	//	public Car mapToCar(CarRequestDto carRequestdto)
	//	{
	//		return carMapper.mapToCar(carRequestdto) ;	
	//	}

	//		@RequestMapping(value="/car/addCar",method = RequestMethod.POST)
	//		public Car addCar(@RequestBody Car car) 
	//		{
	//			return carService.addCar(car);
	//		}
	//		
	//		@RequestMapping(value = "/car/findByCarId",method = RequestMethod.GET)
	//		public Car findByCarId(@RequestParam int carId)
	//		{
	//			return carService.findByCarId(carId);
	//		}




	//	@GetMapping("/car/findAll")
	//	public ResponseEntity<ResponseStructure<Car>> findAll()
	//	{
	//		return carService.findAll();
	//	}


	//@PostMapping("/car/addCar")
	@PostMapping("/car")
	public ResponseEntity<ResponseStructure<CarResponseDto>> addCar(@RequestBody CarRequestDto carRequestDto) 
	{
		return carService.addCar(carRequestDto);

	}

	//	http://localhost:8080/car/
	@GetMapping("/car/{carId}")
	public ResponseEntity<ResponseStructure<CarResponseDto>> findByCarId(@PathVariable int carId) 
	{
		return carService.findByCarId(carId);
	}

	@PutMapping("/car/{carId}")
	public ResponseEntity<ResponseStructure<CarResponseDto>> updateByCarId( @PathVariable int carId, @RequestBody CarRequestDto updatedCarRequest)
	{
		return carService.updateByCarId(carId, updatedCarRequest);

	}
	
	@GetMapping("/car")
	public ResponseEntity<ResponseStructure<List<CarResponseDto>>> findAllCars()
	{
		return carService.findAllCars();
	}
	
	@DeleteMapping("/car/{carId}")
	public ResponseEntity<ResponseStructure<CarResponseDto>> deleteByCarId(@PathVariable  int carId)
	{
		return carService.deleteByCarId(carId);
	}
}