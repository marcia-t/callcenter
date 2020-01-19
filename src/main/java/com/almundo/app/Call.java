package com.almundo.app;
import java.util.concurrent.ThreadLocalRandom;


/**
 * This class represents the call entity
 * It responsibility is to execute the task of the calls inside the dispatcher thread, that's why it implements 'Runnable'
 */
public class Call implements Runnable {

    Employee employee;
    double duration;

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public double getDuration() {
        return duration;
    }

    /**
     * when a call starts, it sets its duration between 5 and 10 secs.
     */
    public void setDuration() {
        int duration = ThreadLocalRandom.current().nextInt(5, 11);
        this.duration = duration;
    }

    /**
     * This is the task that will execute from the dispatcher
     * Once it finishes, it tells the employee to go back to the queue
     */
    @Override
    public void run() {
        this.setDuration();
        try {
            System.out.println("Call from "+this.employee.id+" starts. It's a(n) "+this.employee.type);
            Thread.sleep((long)this.duration*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Call from "+this.employee.id+" id took:  "+this.duration+" seconds.");
        this.employee.finishCall();
    }
}
