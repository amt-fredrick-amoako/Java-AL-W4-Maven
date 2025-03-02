package com.amalitech;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertThat;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    private BuggyCode app;

    @Before
    public void setUp(){
        app = new BuggyCode();
    }

    @Test
    public void multipliesNumbers(){
        int result = app.multiply(2, 3);
        assertThat(result, equalTo(6));
    }
}
