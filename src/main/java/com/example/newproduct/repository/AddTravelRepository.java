package com.example.newproduct.repository;

import com.example.newproduct.entity.AddTravel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AddTravelRepository extends CrudRepository<AddTravel, Long> {
    List<AddTravel> findByName(String name);
}
