package com.almundo.app;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.PriorityBlockingQueue;

import static org.junit.Assert.*;

public class DispatcherTest {

    Employee sup = new Employee(1, Employee.Type.SUPERVISOR);
    Employee ope = new Employee(2, Employee.Type.OPERATOR);
    Employee dir = new Employee(3, Employee.Type.DIRECTOR);

    @Test
    public void putEmployeeTest() {
        List<Employee> l = new ArrayList<Employee>();
        Dispatcher dis = new Dispatcher(l);
        dis.addEmployee(sup);
        assertFalse(dis.employees.isEmpty());
    }

    @Test
    public void getEmployeeTest(){
        List<Employee> l = new ArrayList<Employee>();
        l.add(ope);
        Dispatcher dis = new Dispatcher(l);
        assertEquals(dis.getEmployee(), ope);
    }

    @Test
    public void getPriorityEmp(){
        List<Employee> l = new ArrayList<Employee>();
        l.add(sup);
        l.add(dir);
        l.add(ope);
        Dispatcher dis = new Dispatcher(l);
        assertEquals(dis.getEmployee(),ope);
        assertEquals(dis.getEmployee(),sup);
        assertEquals(dis.getEmployee(),dir);
        dis.addEmployee(dir);
        assertEquals(dis.getEmployee(), dir);
        assertTrue(dis.employees.isEmpty());
    }
}