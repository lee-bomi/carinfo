package com.zerobase.carinfo.controller;

import com.zerobase.carinfo.domain.Company;
import com.zerobase.carinfo.service.CompanyInputDto;
import com.zerobase.carinfo.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/")
public class BasicController {

    @Autowired
    CompanyService companyService;

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
}
