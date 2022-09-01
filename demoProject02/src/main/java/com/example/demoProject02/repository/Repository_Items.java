package com.example.demoProject02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProject02.dto.Items;

public interface Repository_Items extends JpaRepository<Items, Integer> {

}
