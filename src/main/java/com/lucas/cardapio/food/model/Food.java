package com.lucas.cardapio.food.model;

import com.lucas.cardapio.food.model.dto.FoodRequestDTO;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "t_cardapio")
@Entity(name = "t_cardapio")
@EqualsAndHashCode(of = "id")
public class Food {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private String image;

    private Integer price;

    public Food(FoodRequestDTO dto) {
        this.name = dto.name();
        this.image = dto.image();
        this.price = dto.price();
    }
}
