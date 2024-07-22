package com.manju.csa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manju.csa.entity.Car;

@Repository
public interface CarRepository  extends JpaRepository<Car, Integer>{

}
