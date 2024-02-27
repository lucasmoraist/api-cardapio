package com.lucas.cardapio.food.model.dto;

import com.lucas.cardapio.food.model.Food;

public record FoodResponseDTO(Long id, String name, String image, Integer price) {
    
    public FoodResponseDTO(Food food){
        this(food.getId(), food.getName(), food.getImage(), food.getPrice());
    }

}