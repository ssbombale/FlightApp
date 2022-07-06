package com.user.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.entity.AirLine;


public interface IAirLineRepostiory extends JpaRepository<AirLine, Long>{

	List<AirLine> findByAirlineName(String airLineName);

}
