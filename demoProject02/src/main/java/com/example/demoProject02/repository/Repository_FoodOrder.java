package com.example.demoProject02.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demoProject02.dto.FoodOrder;

public interface Repository_FoodOrder extends JpaRepository<FoodOrder, Integer> {

}
