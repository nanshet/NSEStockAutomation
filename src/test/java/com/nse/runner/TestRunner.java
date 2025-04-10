package com.nse.runner;

import java.util.Collections;

import org.testng.TestNG;
import org.testng.annotations.Test;


public class TestRunner {
    public static void main(String[] args) {
        TestNG testng = new TestNG();
        testng.setTestSuites(Collections.singletonList("testng.xml"));
        testng.run();
    }
}