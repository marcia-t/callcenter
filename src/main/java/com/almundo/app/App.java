package com.almundo.app;

import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws InterruptedException {
        System.out.println( "Hello World!" );

        List<Employee> l = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            l.add(new Employee(i, Employee.Type.OPERATOR));
        }

        for (int i = 2; i < 3; i++) {
            l.add(new Employee(i, Employee.Type.SUPERVISOR));
        }

        for (int i = 3; i < 5; i++) {
            l.add(new Employee(i, Employee.Type.DIRECTOR));
        }

        Dispatcher callCenter = new Dispatcher(l);

        for (int i = 0; i < 10; i++) {
            Call c = new Call();
            Thread.sleep(1000);
            callCenter.dispatchCall(c);
        }
        callCenter.stop();
    }
}
