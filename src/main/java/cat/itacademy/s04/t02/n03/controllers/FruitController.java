package cat.itacademy.s04.t02.n03.controllers;


import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.services.FruitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping ("/fruits")
public class FruitController {

    @Autowired
    private FruitService fruitService;

    @PostMapping ("/add")
    public ResponseEntity<Fruit> addFruit (@RequestBody Fruit fruit){

        return ResponseEntity.ok(fruitService.add(fruit));

    }

    @PutMapping ("/update")
    public ResponseEntity<Fruit> updateFruit (@RequestBody Fruit fruit){

        return ResponseEntity.ok(fruitService.update(fruit));

    }

    @DeleteMapping ("/delete/{id}")
    public ResponseEntity<Void> deleteFruit (@PathVariable String id ){

        fruitService.delete(id);

        return ResponseEntity.noContent().build();

    }

    @GetMapping ("/getOne/{id}")
    public ResponseEntity<Fruit> getFruitById (@PathVariable String id){


        return fruitService.getOne(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());

    }

    @GetMapping ("/getAll")
    public ResponseEntity<List<Fruit>> getAllFruits (){

        return ResponseEntity.ok(fruitService.getAll());

    }



}
