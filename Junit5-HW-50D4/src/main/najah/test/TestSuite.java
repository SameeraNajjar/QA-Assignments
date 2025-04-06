package main.najah.test;

import org.junit.jupiter.api.DisplayName;

import org.junit.platform.suite.api.SelectPackages;
import org.junit.platform.suite.api.Suite;


//@SelectClasses({CalculatorTest.class, ProductTest.class, UserServiceTest.class, RecipeBookTest.class})
@Suite
@SelectPackages("main.najah.test")
@DisplayName("Sameera")
public class TestSuite {
	
}