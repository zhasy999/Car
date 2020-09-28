package com.example.demo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
@Getter
@Table(name = "cars")
public class Car {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ApiModelProperty(notes = "This car name")
    private String title;

    @Column
    private String type;

    @Column
    private double power;


    public Car(String title, String type, double power) {
        this.title = title;
        this.type = type;
        this.power = power;
    }

}
