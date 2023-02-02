package com.zerobase.carinfo.repository;

import com.zerobase.carinfo.domain.Car;
import com.zerobase.carinfo.domain.Company;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
