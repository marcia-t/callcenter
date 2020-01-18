package com.almundo.app;

import java.util.concurrent.PriorityBlockingQueue;

public class Dispatcher {

    PriorityBlockingQueue<Employee> employees;

    public Dispatcher(PriorityBlockingQueue<Employee> employees) {
        this.employees = employees;
    }

    public PriorityBlockingQueue<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(PriorityBlockingQueue<Employee> employees) {
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


