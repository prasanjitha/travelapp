package com.example.newproduct.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
public class AddTravel {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;

    @NotBlank(message = "Name is mandatory")
    @Column(name = "name")
    private String name;

    @Column(name = "contact_no")
    private int contactNo;

    @Column(name = "number_of_members")
    private int numberOfMembers;

    @Column(name = "date")
    private String date;

    @Column(name = "number_of_days")
    private int numberOfDays;

    @Column(name = "bus_type")
    private String busType;

    @Column(name = "location")
    private String location;
  public AddTravel(){

  }
    public AddTravel(long id, String name, int contactNo, int numberOfMembers, String date, int numberOfDays, String busType, String location) {
        this.id = id;
        this.name = name;
        this.contactNo = contactNo;
        this.numberOfMembers = numberOfMembers;
        this.date = date;
        this.numberOfDays = numberOfDays;
        this.busType = busType;
        this.location = location;
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

    public int getContactNo() {
        return contactNo;
    }

    public void setContactNo(int contactNo) {
        this.contactNo = contactNo;
    }

    public int getNumberOfMembers() {
        return numberOfMembers;
    }

    public void setNumberOfMembers(int numberOfMembers) {
        this.numberOfMembers = numberOfMembers;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getNumberOfDays() {
        return numberOfDays;
    }

    public void setNumberOfDays(int numberOfDays) {
        this.numberOfDays = numberOfDays;
    }

    public String getBusType() {
        return busType;
    }

    public void setBusType(String busType) {
        this.busType = busType;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
