package com.konrad.projekt;

import java.util.Comparator;

/**
 * Created by Konrad on 02.02.2017.
 */
public class MyHridComparatorAsc implements Comparator<Employee> {

    @Override
    public int compare(Employee e1, Employee e2) {
        if(e1.getHrid() > e2.getHrid()) {
            return 1;
        } else {
            return -1;
        }
    }
}
