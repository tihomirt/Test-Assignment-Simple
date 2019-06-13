package com.example.qa.suites;

import com.example.qa.tests.MapTests;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
    MapTests.class,  
})
public class Suite {

}