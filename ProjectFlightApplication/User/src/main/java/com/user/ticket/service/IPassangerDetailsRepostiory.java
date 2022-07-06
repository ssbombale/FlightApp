package com.user.ticket.service;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.user.ticket.entity.PassangerDetails;

public interface IPassangerDetailsRepostiory extends JpaRepository<PassangerDetails, Long> {

	List<PassangerDetails> findByPnrNumber(String pnrNumber);

	void deleteByPnrNumber(String pnrNumber);

}
