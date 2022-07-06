package com.admin.service;

import org.springframework.data.jpa.repository.JpaRepository;

import com.admin.entity.Useraccount;

public interface IUseraccountRepostiory extends JpaRepository<Useraccount, Long> {

	Useraccount findByUserName(String username);

}
