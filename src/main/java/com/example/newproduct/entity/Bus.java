package com.example.newproduct.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class Bus {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @NotBlank(message = "Number is mandatory")
    @Column(name = "number")
    private String number;

    @Column(name = "type")
    private String type;

    @Column(name = "seats")
    private String seats;

    @Column(name = "description")
    private String description;

   public Bus(){

    }

    public Bus( String name, String number, String type, String seats, String description) {
        this.name = name;
        this.number = number;
        this.type = type;
        this.seats = seats;
        this.description = description;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSeats() {
        return seats;
    }

    public void setSeats(String seats) {
        this.seats = seats;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
