package com.example.demo.mysql.k8s.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.mysql.k8s.model.User;

public interface UserRepository extends JpaRepository<User, Long> {

}
