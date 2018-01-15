package com.momenton.code.challenge.dto;

import com.momenton.code.challenge.exceptions.EmployeeDataException;

/**
 * Created by Eric Ralhan on 14/01/2017.
 */
public class Employee {

    private Integer id;
    private Integer managerId;
    private String name;

    public Employee(Integer id, Integer managerId, String name) {

        if (id == null || id < 1) {
            throw new EmployeeDataException("EmployeeId cannot be less than 1");
        }
        if (name == null || name.isEmpty()) {
            throw new EmployeeDataException("Employee must have a name");
        }
        this.id = id;
        this.managerId = managerId;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public Integer getManagerId() {
        return managerId;
    }

    public String getName() {
        return name;
    }

}
