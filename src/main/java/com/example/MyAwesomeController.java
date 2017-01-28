package com.example;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Michał on 27-01-2017.
 */
@RestController
public class MyAwesomeController {
    @Autowired
    MyAwesomeService myAwesomeService;

    @RequestMapping
    public String hello() {     //tu nazwy metod nie mają znaczenia ze względu na logikę programu
        return "Hello world!";

    }

    @RequestMapping("/hello")
    public String hello2() {
        double result = myAwesomeService.add(2, 2);
        return "Hello World " + result;
    }

    @RequestMapping("/hello3/{name}") //localhost:9000/hello3/Mike
    public String hello3(@PathVariable("name") String name) {
        return "Hava a nice day " + name;
    }

    @RequestMapping("/hello4") //localhost:9000/hello4?name=Mike
    public String hello4(@RequestParam("name") String name) { //lub @RequestParam String name - domyślnie mapuje po nazwie parametru
        return "Hava a nice day " + name;
    }

    @RequestMapping("/hello5")  //http://localhost:9000/hello5?name=Mike&surname=Gieysztor
    public String hello5(@RequestParam("name") String name,
                         @RequestParam(required = false, defaultValue = "Kowalski") String surname) {
        return "Hava a nice day " + name + " " + surname;
    }

    @RequestMapping("/hello6")
    public String hello6(@RequestParam("name") String name, @RequestParam(value = "surname", required = false) String surname) {
        return "Hello World from Michał to " + name + " " + surname;
    }

    @RequestMapping("/hello7/{name}")
    public String hello7(@PathVariable("name") String name) {
        return "Hello World from Michał to " + name;
    }

    @RequestMapping("/customer")
    public Customer customer() {
        Customer customer = new Customer("Jakub", "Kowalski");
        return customer;
    }


    @RequestMapping(value = "/message", method = RequestMethod.POST)
    public void message(@RequestBody String message) {
        System.out.println("podana wiadomość to: " + message);
    }
}
