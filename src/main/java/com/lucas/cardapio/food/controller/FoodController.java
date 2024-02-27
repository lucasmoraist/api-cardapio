package com.lucas.cardapio.food.controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.lucas.cardapio.food.model.Food;
import com.lucas.cardapio.food.model.dto.FoodRequestDTO;
import com.lucas.cardapio.food.model.dto.FoodResponseDTO;
import com.lucas.cardapio.food.repository.FoodRepository;

@RestController
@RequestMapping("/food")
public class FoodController {

    // Injetando o repository sem a utilização do @Autowired
    private FoodRepository repository;

    public FoodController(FoodRepository repository) {
        this.repository = repository;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/list")
    public List<FoodResponseDTO> findAll() {
        List<FoodResponseDTO> foodList = this.repository.findAll().stream().map(FoodResponseDTO::new).toList();
        return foodList;
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping("/new")
    public ResponseEntity<Food> save(@RequestBody FoodRequestDTO dto) throws Exception {
        Food food = new Food(dto);
        var newFood = this.repository.save(food);
        return ResponseEntity.ok(newFood);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping("/update/{id}")
    public ResponseEntity<Food> update(@PathVariable Long id, @RequestBody Food food) throws Exception {

        this.repository.findById(id)
                .orElseThrow(() -> new Exception("Comida não encontrada"));

        food.setId(id);
        repository.save(food);

        return ResponseEntity.ok(food);
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Food> delete(@PathVariable Long id) throws Exception{
        
        var food = this.repository.findById(id).orElseThrow(() -> new Exception("Comida não encontrada"));
        repository.delete(food);

        return ResponseEntity.noContent().build();
    }
}
