package com.example.newproduct.repository;
import java.util.List;

import com.example.newproduct.entity.Driver;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends CrudRepository <Driver, Long> {
    List<Driver> findByName(String name);
}
