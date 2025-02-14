package cat.itacademy.s04.t02.n03.services;


import cat.itacademy.s04.t02.n03.exception.FruitNotFoundException;
import cat.itacademy.s04.t02.n03.model.Fruit;
import cat.itacademy.s04.t02.n03.repository.FruitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FruitService {

    @Autowired
    private FruitRepository fruitRepository;

    public Fruit add(Fruit fruit) {

        return fruitRepository.save(fruit);

    }


    public Fruit update(Fruit fruit) {

        if (fruit.getId().equals("0")  || !fruitRepository.existsById(fruit.getId())) {

            throw new FruitNotFoundException("The id is null or the fruit  doenst exist");
        }

        return fruitRepository.save(fruit);

    }

    public void delete(String id) {

        if (id.equals("0") || !fruitRepository.existsById(id)) {

            throw new FruitNotFoundException("The id is null or the fruit  doenst exist");

        }

        fruitRepository.deleteById(id);

    }


    public Optional<Fruit> getOne(String id) {

        if (id.equals("0") || !fruitRepository.existsById(id)) {

            throw new IllegalArgumentException("The id is null or the fruit  doenst exist");


        }

        return fruitRepository.findById(id);


    }

    public List<Fruit> getAll () {

        return fruitRepository.findAll();


    }






}
