package com.almundo.app;

import java.util.PriorityQueue;

/**
 * This class represents the employee entity
 * It implements the "comparable" interface to handle priorities between employees
 * and to be used inside a PriorityBlockingQueue
 */

public class Employee  implements Comparable<Employee>{

    Integer id;
    Type type;
    Dispatcher dispatcher;

    enum Type{
        OPERATOR, SUPERVISOR, DIRECTOR
    }

    public Employee(Integer id, Type type) {
        this.id = id;
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public Type getType() {
        return type;
    }

    public Dispatcher getDispatcher() {
        return dispatcher;
    }

    public void setDispatcher(Dispatcher dispatcher) {
        this.dispatcher = dispatcher;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.type.compareTo(employee.type);
    }

    public void finishCall(){
        this.dispatcher.addEmployee(this);
    }
}
