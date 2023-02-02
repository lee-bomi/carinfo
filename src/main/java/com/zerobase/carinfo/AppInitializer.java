package com.zerobase.carinfo;

import com.zerobase.carinfo.domain.Car;
import com.zerobase.carinfo.domain.Company;
import com.zerobase.carinfo.service.CarService;
import com.zerobase.carinfo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Component
public class AppInitializer {

    @Autowired
    CompanyService companyService;

    @Autowired
    CarService carService;

    @PostConstruct
    private void init() {
        Company company1 = new Company();
        company1.setUpdatedAt(new Date());
        company1.setCreatedAt(new Date());
        company1.setName("BMW");
        company1.setNation("독일");

        Company company2 = new Company();
        company2.setUpdatedAt(new Date());
        company2.setCreatedAt(new Date());
        company2.setName("기아");
        company2.setNation("한국");

        companyService.save(company1);
        companyService.save(company2);

        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company("현대", "한국"));
        companyList.add(new Company("쌍용", "한국"));
        companyList.add(new Company("볼보", "스웨덴"));
        companyList.add(new Company("벤츠", "독일"));
        companyList.add(new Company("아우디", "독일"));
        companyList.add(new Company("르노", "프랑스"));
        companyList.add(new Company("테슬라", "미국"));
        companyList.add(new Company("대우", "한국"));
        companyList.add(new Company("큐브", "일본"));
        companyList.add(new Company("도요타", "일본"));
        companyList.add(new Company("미니", "미국"));
        companyList.add(new Company("트레일블레이저", "독일"));

        companyService.saveAll(companyList);

        List<Car> carList = new ArrayList<>();
        carList.add(new Car("M1", company1, 5));
        carList.add(new Car("M2", company1, 5));
        carList.add(new Car("M3", company1, 5));
        carList.add(new Car("M4", company1, 5));
        carList.add(new Car("M5", company1, 5));
        carList.add(new Car("M6", company1, 5));
        carList.add(new Car("소나타", company2, 5));
        carList.add(new Car("아반떼", company2, 5));
        carList.add(new Car("모닝", company2, 5));
        carList.add(new Car("엑센트", company2, 5));
        carList.add(new Car("그랜저", company2, 5));
        carList.add(new Car("산타페", company2, 5));
        carService.saveAll(carList);
    }
}
