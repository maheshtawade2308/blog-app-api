package com.comptask.userManagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.comptask.userManagement.model.User;

public interface UserRepository extends JpaRepository< User, Integer> {

}
