package com.example;

import io.micronaut.test.extensions.junit5.annotation.MicronautTest;
import io.restassured.specification.RequestSpecification;
import jakarta.inject.Inject;
import org.hamcrest.CoreMatchers;
import org.junit.jupiter.api.Test;

@MicronautTest
public class TestEmployeeEndpoint {

    @Inject
    EmployeeRepository repository;

    @Test
    void testEmployeeEndpoint(RequestSpecification specification) {
        /*
        * Even after inserting employee data,
        * this test case will fail with NoSuchElementException
        * */
        Employee e = new Employee();
        e.setName("Dumdum");
        repository.save(e);
        specification.get("/")
                .then().statusCode(200)
                .body(CoreMatchers.equalTo(""));
    }
}
