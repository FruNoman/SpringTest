package com.github.frunoman.spring_boot_tests.tests;

import com.github.frunoman.spring_boot_tests.SpringBootTestsTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.testng.annotations.BeforeMethod;

public class BaseTest {


    @BeforeMethod
    public void beforeMethod() {
    }
}
