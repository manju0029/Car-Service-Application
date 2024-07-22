package com.manju.csa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.manju.csa.entity.Service;

@Repository
public interface ServiceRepository  extends JpaRepository<Service, Integer>{

}
