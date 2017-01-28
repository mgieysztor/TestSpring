package com.example;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by RENT on 2017-01-28.
 */
@Service
public class CarService {
    List<Car> cars = new ArrayList<>();



    public CarService(){
        cars.add(new Car("Opel","Vectra", 2001, "Silver",5, "123"));
        cars.add(new Car("Mazda","6", 2005, "Black",5,"234"));
        cars.add(new Car("Ford","Mondeo", 2005, "Red",5,"345"));
    }
    public List<Car> getCars() {
        return cars;
    }

    public Car getById(String id) throws CarNotFoundException {
        return cars.stream()
                .filter(x->x.getId().equals(id))
                .findFirst()
                .orElseThrow(()->new CarNotFoundException());
    }

    public List<Car> getByBrand(String brand){
        return cars.stream()
                .filter(x->x.getBrand().equals(brand))
                .collect(Collectors.toList());
    }

    public void add(Car car){
        cars.add(car);
    }

}
