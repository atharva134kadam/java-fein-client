package com.car.repository;

import com.car.entity.car;
import org.springframework.data.jpa.repository.JpaRepository;

public interface carRepository extends JpaRepository<car, Integer> {
}