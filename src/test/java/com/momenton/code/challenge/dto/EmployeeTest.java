package com.momenton.code.challenge.dto;

import com.momenton.code.challenge.exceptions.EmployeeDataException;
import org.junit.Test;

/**
 * Created by Eric Ralhan on 14/01/2017.
 */
public class EmployeeTest {

    @Test(expected = EmployeeDataException.class)
    public void should_throw_exception_if_id_is_null() {
        new Employee(null, 1, "testName");
    }

    @Test(expected = EmployeeDataException.class)
    public void should_throw_exception_if_id_is_less_than_1() {
        new Employee(0, 1, "testName");
    }

    @Test
    public void should_create_a_valid_employee() {
        new Employee(2, 1, "testName");
    }

    @Test(expected = EmployeeDataException.class)
    public void should_throw_exception_if_name_is_null() {
        new Employee(10, null, null);
    }

    @Test(expected = EmployeeDataException.class)
    public void should_throw_exception_if_name_is_empty() {
        new Employee(10, null, "");
    }

}
