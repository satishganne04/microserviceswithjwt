package com.microservicesexample.departmentservice.service;

import com.microservicesexample.departmentservice.entity.Department;
import com.microservicesexample.departmentservice.repository.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;


    public Department saveDapartment(Department department) {
        log.info("inside save department method of service");
        return departmentRepository.save(department);

    }

    public Department findDepartmentId(Long departmentid) {
        log.info("inside finfbyid department method of service");
        return departmentRepository.findByDepartmentId(departmentid);
    }
}
