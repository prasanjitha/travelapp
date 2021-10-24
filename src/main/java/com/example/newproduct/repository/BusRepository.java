package com.example.newproduct.repository;
import com.example.newproduct.entity.Bus;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends CrudRepository<Bus, Long> {
    List<Bus> findByName(String name);
}
