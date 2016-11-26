package com.linly.androidutils;

import com.linly.androidutils.activitys.Calculator;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by linly on 2016/11/22.
 */
public class CalculatorTest {
    private Calculator mCalculator;
    @Before
    public void setUp() throws Exception {
        mCalculator = new Calculator();
    }

    @Test
    public void sum() throws Exception {
        assertEquals("sum",5d,mCalculator.sum(1,4),0);
    }

    @Test
    public void substract() throws Exception {
        assertEquals("substract",3,mCalculator.substract(4,1),0);
    }

    @Test
    public void divide() throws Exception {
        assertEquals("divide",2,mCalculator.divide(4,2),0);
    }

    @Test
    public void multiply() throws Exception {
        assertEquals("multiply",8,mCalculator.multiply(4,2),0);
    }

}