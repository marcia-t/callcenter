package com.almundo.app;

import org.junit.Test;

import java.util.PriorityQueue;

import static org.junit.Assert.*;

public class DispatcherTest {

    Employee sup = new Employee(1, Employee.Type.SUPERVISOR);
    Employee ope = new Employee(2, Employee.Type.OPERATOR);
    Employee dir = new Employee(3, Employee.Type.DIRECTOR);



    @Test
    public void putEmployeeTest() {
        Dispatcher dis = new Dispatcher(new PriorityQueue<Employee>());
        dis.addEmployee(sup);
        assertTrue(!dis.employees.isEmpty());
    }

    @Test
    public void getEmployeeTest(){
        Dispatcher dis = new Dispatcher(new PriorityQueue<Employee>());
        dis.addEmployee(ope);
        assertEquals(dis.getEmployee(), ope);
    }

    @Test
    public void getPriorityEmp(){
        Dispatcher dis = new Dispatcher(new PriorityQueue<Employee>());
        dis.addEmployee(ope);
        dis.addEmployee(sup);
        dis.addEmployee(dir);
        assertEquals(dis.getEmployee(),ope);
        assertEquals(dis.getEmployee(),sup);
        assertEquals(dis.getEmployee(),dir);

        assertTrue(dis.employees.isEmpty());
    }
}