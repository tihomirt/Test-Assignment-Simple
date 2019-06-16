package com.qa.suites;

import com.qa.tests.MapTests;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.SelectClasses;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectClasses({
    MapTests.class,  
})

public class Suite {

}