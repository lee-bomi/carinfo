package com.zerobase.carinfo.controller;

import com.zerobase.carinfo.domain.Car;
import com.zerobase.carinfo.domain.Company;
import com.zerobase.carinfo.service.CarInputDto;
import com.zerobase.carinfo.service.CarService;
import com.zerobase.carinfo.service.CompanyInputDto;
import com.zerobase.carinfo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/")
public class BasicController {

    @Autowired
    CompanyService companyService;

    @Autowired
    CarService carService;

    @RequestMapping("/")
    public String index(Model model) {
        return "index";
    }

    @RequestMapping("/companyForm")
    public String companyForm(Model model) {
        return "companyForm";
    }

    @PostMapping("/saveCompany")
    public String saveCompany(@ModelAttribute(name = "companyInputDto") CompanyInputDto dto, Model model) {

        companyService.saveCompanyInputDto(dto);
        return "index";
    }

    @RequestMapping("/companyList")
    public String companyList(@PageableDefault Pageable pageable, Model model) {
        Page<Company> companyList = companyService.getCompanyPage(pageable);
        model.addAttribute("companyList", companyList);

        return "companyList";
    }

    @RequestMapping("/carForm")
    public String carList(Model model) {
        List<Company> companyList = companyService.findAll();
        model.addAttribute("companyList", companyList);
        return "carForm";
    }

    @PostMapping("/saveCar")
    public String saveCar(@ModelAttribute(name = "carInputDto") CarInputDto dto, Model model) {
        carService.saveCarInputDto(dto);

        return "index";
    }

    @RequestMapping("/carList")
    public String carList(@PageableDefault Pageable pageable, Model model) {
        Page<Car> carList = carService.getCarPage(pageable);
        model.addAttribute("carList", carList);

        return "carList";
    }
}
