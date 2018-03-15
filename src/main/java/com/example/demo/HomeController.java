package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/")
    public String index(Model model){
        Employee employee = new Employee();
        employee.setName("Desire Mpondo");
        employee.setSsn("111-222-3333");

        Laptop laptop = new Laptop();
        laptop.setBrand("Dell");
        laptop.setModel("Latitude XL500");
        employee.setLaptop(laptop);
        employeeRepository.save(employee);

        model.addAttribute("employees", employeeRepository.findAll());
        return "index";
    }

}
