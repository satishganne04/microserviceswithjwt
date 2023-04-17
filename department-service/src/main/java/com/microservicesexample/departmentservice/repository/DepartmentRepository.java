package com.microservicesexample.departmentservice.repository;

import com.microservicesexample.departmentservice.entity.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department,Long> {









    Department findByDepartmentId(Long departmentid);
}
