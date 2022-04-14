package com.trees;

import org.testng.annotations.*;
import static org.testng.Assert.*;

public class DriverTest {
    @Test public void appHasAGreeting() {
        Driver classUnderTest = new Driver();
        assertNotNull(classUnderTest.getGreeting(), "app should have a greeting");
    }
}
