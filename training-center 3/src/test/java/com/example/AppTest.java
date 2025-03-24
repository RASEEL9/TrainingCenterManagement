package com.example;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 * Unit test for simple App.
 */
public class AppTest {

    /**
     * Sample test to check if JUnit 5 is working correctly
     */
    @Test
    void testApp() {
        assertTrue(true, "The test should always pass");
    }

    /**
     * Another example test
     */
    @Test
    void testSum() {
        int expected = 2;
        int actual = 1 + 1;
        assertEquals(expected, actual, "1 + 1 should equal 2");
    }
}
