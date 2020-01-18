package com.almundo.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class EmployeeTest {

    Employee sup = new Employee(1, Employee.Type.SUPERVISOR);
    Employee ope = new Employee(2, Employee.Type.OPERATOR);
    Employee dir = new Employee(3, Employee.Type.DIRECTOR);

    @Test
    public void compareOpe() {
        int opeToSup = this.ope.compareTo(this.sup);
        int opeToDir = this.ope.compareTo(this.dir);
        int opeToOpe = this.ope.compareTo(this.ope);
        assertTrue(opeToSup < 0);
        assertTrue(opeToDir < 0);
        assertEquals(opeToOpe, 0);

    }

    @Test
    public void compareSup(){
        int supToOpe = this.sup.compareTo(this.ope);
        int supToSup = this.sup.compareTo(this.sup);
        int supToDir = this.sup.compareTo(this.dir);
        assertTrue(supToOpe > 0);
        assertEquals(supToSup, 0);
        assertTrue(supToDir < 0);
    }

    @Test
    public void compareDir(){
        int dirToOpe = this.dir.compareTo(this.ope);
        int dirToSup = this.dir.compareTo(this.sup);
        int dirToDir = this.dir.compareTo(this.dir);
        assertTrue(dirToOpe > 0);
        assertTrue(dirToSup > 0);
        assertEquals(dirToDir, 0);

    }

}