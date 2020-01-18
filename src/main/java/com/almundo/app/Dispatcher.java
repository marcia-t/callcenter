package com.almundo.app;

import java.util.PriorityQueue;

public class Dispatcher {

    PriorityQueue<Employee> employees;

    public Dispatcher(PriorityQueue<Employee> employees) {
        this.employees = employees;
    }

    public PriorityQueue<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(PriorityQueue<Employee> employees) {
        this.employees = employees;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public Employee getEmployee(){
        Employee e = employees.poll();
        return e;
    }
}


