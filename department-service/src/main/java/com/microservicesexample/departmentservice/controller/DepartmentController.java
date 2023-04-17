package com.microservicesexample.departmentservice.controller;

import com.microservicesexample.departmentservice.entity.Department;
import com.microservicesexample.departmentservice.service.DepartmentService;
import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/departments")
@Slf4j
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department){
        log.info("inside save department method of controller");
        return  departmentService.saveDapartment(department);

    }

    @GetMapping("/getdepartmentids/{id}")
    public Department finfDepartmentById(@PathVariable("id") Long departmentid){
        log.info("inside finfbyid department method of controller");
        return departmentService.findDepartmentId(departmentid);
    }
}
