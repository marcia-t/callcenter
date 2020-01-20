package com.almundo.app;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.PriorityBlockingQueue;

/**
 * This class represents the Dispatcher
 * Its responsibility is to receive calls and to send them to
 * its employees, according to their priorities
 */
public class Dispatcher {

    PriorityBlockingQueue<Employee> employees;
    ExecutorService service;

    public Dispatcher(List<Employee> employees) {
        this.employees = this.setQueue(employees);
        this.service = Executors.newFixedThreadPool(this.employees.size() == 0 ? 10 : this.employees.size());
    }

    public PriorityBlockingQueue<Employee> setQueue (List<Employee> employees){
        PriorityBlockingQueue<Employee> q = new PriorityBlockingQueue<>();
        for (Employee emp: employees) {
            emp.setDispatcher(this);
            q.put(emp);
        }
        return q;
    }

    public void addEmployee(Employee employee){
        employees.add(employee);
    }

    public Employee getEmployee(){
        Employee e = null;
        try {
            e = employees.take();
        } catch (InterruptedException ex) {
            System.out.println("Error taking employee");
            ex.printStackTrace();
        }
        return e;
    }

    /**
     * This method receives the call, takes an employee from the priority queue and submits a task to the service
     * @param call
     */
    public void dispatchCall(Call call){
        Employee e = this.getEmployee();
        call.setEmployee(e);
        service.submit(call);
    }

    /**
     * Shutdown the dispatcher
     */
    public void stop(){
        service.shutdown();
    }
}


