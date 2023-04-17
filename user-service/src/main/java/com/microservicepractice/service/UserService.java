package com.microservicepractice.service;

import com.microservicepractice.VO.Department;
import com.microservicepractice.VO.ResponseTemplateVO;
import com.microservicepractice.entity.User;
import com.microservicepractice.repository.UserRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;

@Service
@Slf4j
public class UserService {
    @Autowired
    private UserRepository userRepository;


    @Autowired
    private LoadBalancerClient loadBalancerClient;

    public User saveUser(User user) {
        log.info("inside saveuser of user service");
       return  userRepository.save(user);
    }

    /*public ResponseTemplateVO getUserWithDepartment(Long userId) {
       ResponseTemplateVO responseTemplateVO=new ResponseTemplateVO();
       User user=userRepository.findByUserId(userId);
        Department department=restTemplate.getForObject
                ("http://DEPARTMENT-SERVICE/departments/getdepartmentids/"+user.getDepartmentId(),Department.class);
        responseTemplateVO.setUser(user);
        responseTemplateVO.setDepartment(department);
        return responseTemplateVO;
   }*/



    public Mono<ResponseTemplateVO> getUserWithDepartment(Long userId) {
        ResponseTemplateVO responseTemplateVO = new ResponseTemplateVO();
        User user = userRepository.findByUserId(userId);
        String departmentServiceUrl = loadBalancerClient.choose("DEPARTMENT-SERVICE").getUri().toString();
        return WebClient.builder()
                .baseUrl(departmentServiceUrl)
                .build()
                .get()
                .uri("/departments/getdepartmentids/" + user.getDepartmentId())
                .retrieve()
                .bodyToMono(Department.class)
                .map(department -> {
                    responseTemplateVO.setUser(user);
                    responseTemplateVO.setDepartment(department);
                    return responseTemplateVO;
                });
    }
}
