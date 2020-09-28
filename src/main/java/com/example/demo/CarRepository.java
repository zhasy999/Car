package com.example.demo;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface CarRepository extends CrudRepository<Car, Long> {

    Car findCarByTitleIgnoreCase(String title);

    Car findCarById(Long id);

    List<Car> findAll();

}
