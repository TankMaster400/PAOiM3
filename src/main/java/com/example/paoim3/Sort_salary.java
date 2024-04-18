package com.example.paoim3;

import java.util.Comparator;

public class Sort_salary  implements Comparator<Employee> {
    @Override
    public int compare(Employee prac1, Employee prac2) {
        return (int) (prac2.wynagrodzenie - prac1.wynagrodzenie);

    }
}