package com.almundo.app;

import java.util.PriorityQueue;

/**
 * Clase que representa al empleado
 * Implementa la interface comparable para
 * poder ser utilizado en la cola de prioridades
 */

public class Employee  implements Comparable<Employee>{

    Integer id;
    Type type;

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

    public void setId(int id) {
        this.id = id;
    }

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }

    @Override
    public int compareTo(Employee employee) {
        return this.type.compareTo(employee.type);
    }

}
