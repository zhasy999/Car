package com.example.demo;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/car")
public class CarController {

    @Autowired
    private CarService carService;

    @PostMapping("/create")
    public String addCar(@RequestParam String title, @RequestParam String type, @RequestParam double power) {
        Car car = new Car();
        car.setTitle(title);
        car.setType(type);
        car.setPower(power);
        if (carService.addCar(car)) {
            return ("Car " + car + " added");
        }
        return (car + " Already exist");
    }

    @GetMapping
    public List<Car> allCars(){
        return carService.findAll();
    }

    @GetMapping("/{id}")
    public Car findCarById(@PathVariable Long id) {
        return carService.findCarById(id);
    }

}
