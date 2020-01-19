package com.almundo.app;
import java.util.concurrent.ThreadLocalRandom;

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

    public void setDuration() {
        int duration = ThreadLocalRandom.current().nextInt(5, 11);
        this.duration = duration;
    }

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
