package com.example;

import io.micronaut.http.MediaType;
import io.micronaut.http.annotation.Controller;
import io.micronaut.http.annotation.Get;
import jakarta.inject.Inject;

@Controller
public class EmployeeEndPoint {

    @Inject EmployeeRepository repository;


    @Get(produces = MediaType.TEXT_PLAIN)
    public String getEmployee(){
        return repository.findById(1).get().getName();
    }
}
