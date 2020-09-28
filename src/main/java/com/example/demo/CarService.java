package com.example.demo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.transaction.Transactional;
import java.util.List;

@Service
public class CarService {


    private CarRepository carRepo;

    @Transactional
    public boolean addCar(Car car) {
        if (carRepo.findCarByTitleIgnoreCase(car.getTitle()) != null) {
            car.setId(Long.MIN_VALUE);
            System.out.println("Error");
            return false;
        }
        carRepo.save(car);
        return true;
    }

    @Autowired
    public void setCarRepository(CarRepository carRepo) {
        this.carRepo = carRepo;
    }

    @Transactional
    public Car findCarById(Long id) {
        return carRepo.findById(id).get();
    }

    @Transactional
    public List<Car> findAll() {
        List<Car> cars = carRepo.findAll();
        return cars;
    }


}
