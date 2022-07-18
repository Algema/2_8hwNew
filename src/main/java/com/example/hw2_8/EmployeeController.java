package com.example.hw2_8;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(path = "/employee")
public class EmployeeController {              // http://localhost:8080/employee/add?firstName=Ivan&lastName=Ivanov
    private final  EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService){
        this.employeeService=employeeService;
    }

    @GetMapping(path = "/add")
    public Employee add (@RequestParam (value = "firstName",required = false) String userName,
                         @RequestParam (value = "lastName",required = false) String userSurname){
        return EmployeeService.addEmployee(userSurname,userName);
    }

//    @GetMapping(path = "/find")
//    public Employee find  (@RequestParam ("firstName") String userName,
//                           @RequestParam ("lastName") String userSurname){
//        return EmployeeService.findEmployee(userName,userSurname);
//    }

    @GetMapping(path = "/remove")
    public Employee remove (@RequestParam ("firstName") String userName,
                            @RequestParam ("lastName") String userSurname){
        return EmployeeService.removeEmployee(userSurname,userName);
    }

    @GetMapping(path = "/findall")
    public Map<String,Employee> findAll (){
        return EmployeeService.findAll();
    }
}













