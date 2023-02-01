package com.zerobase.carinfo;

import com.zerobase.carinfo.domain.Company;
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

    @PostConstruct
    private void init() {
        List<Company> companyList = new ArrayList<>();
        companyList.add(new Company("기아", "한국"));
        companyList.add(new Company("현대", "한국"));
        companyList.add(new Company("쌍용", "한국"));
        companyList.add(new Company("볼보", "스웨덴"));
        companyList.add(new Company("벤츠", "독일"));
        companyList.add(new Company("BMW", "독일"));
        companyList.add(new Company("아우디", "독일"));
        companyList.add(new Company("르노", "프랑스"));
        companyList.add(new Company("테슬라", "미국"));
        companyList.add(new Company("대우", "한국"));
        companyList.add(new Company("큐브", "일본"));
        companyList.add(new Company("도요타", "일본"));
        companyList.add(new Company("미니", "미국"));
        companyList.add(new Company("트레일블레이저", "독일"));

        companyService.saveAll(companyList);
    }
}
