package com.zerobase.carinfo.service;

import com.zerobase.carinfo.domain.Car;
import com.zerobase.carinfo.domain.Company;
import com.zerobase.carinfo.repository.CarRepository;
import com.zerobase.carinfo.repository.CompanyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

@Service
@Transactional
public class CarService {

    @Autowired
    CarRepository carRepository;
    @Autowired
    CompanyService companyService;

    @Transactional
    public Car saveCarInputDto(CarInputDto carInputDto) {
        Car car = new Car();
        car.setModelName(carInputDto.getModelName());
        car.setPassengerCapacity(carInputDto.getPassengerCapacity());
        car.setCompany(companyService.find(carInputDto.getCompanyId()));  //연관관계를 맺어줘야함
        car.setCreatedAt(new Date());
        car.setUpdatedAt(new Date());

        return carRepository.save(car);
    }

    public Page<Car> getCarPage(Pageable pageable) {
        int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1);
        pageable = PageRequest.of(page, 10, Sort.by(Sort.Direction.DESC, "id"));
        return carRepository.findAll(pageable);
    }

    public void saveAll(List<Car> carList) {
        carRepository.saveAll(carList);
    }
}
