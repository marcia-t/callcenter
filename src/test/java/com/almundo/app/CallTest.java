package com.almundo.app;

import org.junit.Test;

import static org.junit.Assert.*;

public class CallTest {

    @Test
    public void getDurationTest(){
        Call c = new Call();
        c.setDuration();
        assertTrue(c.duration >= (long)5);
        assertTrue(c.duration <= (long)10);
    }

}