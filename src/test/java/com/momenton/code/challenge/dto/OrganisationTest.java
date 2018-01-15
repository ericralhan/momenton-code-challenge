package com.momenton.code.challenge.dto;

import com.momenton.code.challenge.exceptions.EmployeeDataException;
import com.momenton.code.challenge.exceptions.ManagerNotFoundException;
import org.junit.Before;
import org.junit.Test;
import org.powermock.reflect.internal.WhiteboxImpl;

import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * Created by Eric Ralhan on 14/01/2017.
 */
public class OrganisationTest {

    Organisation org;

    @Before
    public void setUp() {
        Employee emp = new Employee(1, null, "ceo");
        org = new Organisation(emp);
        org.addEmployee(new Employee(2, 1, "foo"));
        org.addEmployee(new Employee(3, 2, "bar"));

    }

    @Test(expected = EmployeeDataException.class)
    public void should_throw_exception_when_employee_exists() {
        org.addEmployee(new Employee(2, 1, "testName"));
    }

    @Test(expected = ManagerNotFoundException.class)
    public void should_throw_exception_when_manager_not_found() {
        org.addEmployee(new Employee(4, 100, "testName"));
    }

    @Test(expected = EmployeeDataException.class)
    public void should_throw_exception_when_manager_is_null() {
        org.addEmployee(new Employee(4, null, "testName"));
    }

    @Test
    public void should_induct_a_valid_employee() throws Exception {
        Employee emp = new Employee(4, 2, "testName");
        org.addEmployee(emp);
        boolean result = ((List<Employee>) WhiteboxImpl.getInternalState(org, "employees")).contains(emp);
        assertTrue(result);
    }

    @Test
    public void should_return_true_if_employee_exits() throws Exception {

        boolean result = WhiteboxImpl.invokeMethod(org, "checkIfIdAlreadyExists", 2);
        assertTrue(result);
    }

    @Test
    public void should_return_false_if_employee_does_not_exit() throws Exception {

        boolean result = WhiteboxImpl.invokeMethod(org, "checkIfIdAlreadyExists", 900);
        assertFalse(result);
    }

    @Test
    public void should_return_direct_subordinates() {
        List<Employee> subordinates = org.findDirectSubordinates(org.getCeo());
        assertThat(subordinates.size(), is(1));
        assertThat(subordinates.get(0).getId(), is(2));
    }

    @Test
    public void should_return_correct_level_separators() throws Exception {

        String result = WhiteboxImpl.invokeMethod(org, "getLevelSeparator", 3);
        assertThat(result.length(), is(3));
    }

    @Test
    public void should_return_correct_level_separators_for_ceo() throws Exception {

        String result = WhiteboxImpl.invokeMethod(org, "getLevelSeparator", 0);
        assertThat(result.length(), is(0));
    }
}
