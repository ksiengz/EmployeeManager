package com.konrad.projekt;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Konrad on 02.02.2017.
 */
public class Employee implements Serializable {

    private int hrid;
    private String firstName;
    private String lastName;
    private String department;
    private int salary;
    private String phoneNumber;

    public Employee() {
        this.hrid = 0;
        this.firstName = null;
        this.lastName = null;
        this.department = null;
        this.salary = 0;
        this.phoneNumber = null;
    }

    public Employee(int hrid, String firstName, String lastName, String department, int salary, String phoneNumber) {
        this.hrid = hrid;
        this.firstName = firstName;
        this.lastName = lastName;
        this.department = department;
        this.salary = salary;
        this.phoneNumber = phoneNumber;
    }

    public int getHrid() {
        return hrid;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getDepartment() {
        return department;
    }

    public int getSalary() {
        return salary;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    @Override
    public String toString() {
        return "\nDane pracownika: " + hrid
                + "\nImię: " + firstName
                + "\nNazwisko: " + lastName
                + "\nDzial: " + department
                + "\nPensja: " + salary
                + "\nNumer telefonu: " + phoneNumber + "\n";
    }
}
