package com.momenton.code.challenge;

import com.momenton.code.challenge.dto.Employee;
import com.momenton.code.challenge.dto.Organisation;

/**
 * Created by Eric Ralhan on 13/06/2017.
 */
public class Main {

    public static void main(String[] args) {
        Employee ceo = new Employee(150, null, "Jamie");
        Organisation org = new Organisation(ceo);
        org.addEmployee(new Employee(100, 150, "Alan"));
        org.addEmployee(new Employee(220, 100, "Martin"));
        org.addEmployee(new Employee(275, 100, "Alex"));
        org.addEmployee(new Employee(400, 150, "Steve"));
        org.addEmployee(new Employee(190, 400, "David"));
        org.printOrganisationStructure();

    }
}
