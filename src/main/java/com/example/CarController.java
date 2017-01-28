package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.*;
import java.util.List;

/**
 * Created by RENT on 2017-01-28.
 */
@RestController() //domyślne mapowanie @RestController to "/"
@RequestMapping("/cars")
public class CarController {

    @Autowired
    CarService carService;

    @RequestMapping
    public List<Car> getAllCars(){
        return carService.getCars();
    }

    @RequestMapping("/{id}")
    public Car getCarByID(@PathVariable("id") String id ) throws CarNotFoundException {
        return carService.getById(id);
    }

    @RequestMapping("/car")
//    public Car getById(@PathVariable String id){
    public List<Car> getByBrand(@RequestParam("brand") String brand)  {
        return carService.getByBrand(brand);
    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void addCar(@RequestBody Car car){
//        System.out.println(car);
//    }

//    @RequestMapping(method = RequestMethod.POST)
//    public void addCarToList(@RequestBody Car car){
//        carService.getCars().add(car);
//        System.out.println(car);
//    }

    @RequestMapping(method = RequestMethod.POST)
    public void addCar(@RequestBody Car car){
        carService.add(car);
        System.out.println(car);
    }

}
