package com.lucas.cardapio.food.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.lucas.cardapio.food.model.Food;


public interface FoodRepository extends JpaRepository<Food, Long>{
    Optional<Food> findById(Long id);
}