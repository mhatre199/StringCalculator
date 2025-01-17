package com.hc.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class CalculatorApplicationTests {

	@Test
	void testEmptyString_ReturnsZero() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(0, calculator.Add(""));
	}

	@Test
	void testSingleNumber_ReturnsNumber() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(1, calculator.Add("1"));
	}

	@Test
	void testTwoNumbers_ReturnsSum() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(3, calculator.Add("1,2"));
	}

	@Test
	void testUnknownAmountOfNumbers_ReturnsSum() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(10, calculator.Add("1,2,3,4"));
		assertEquals(15, calculator.Add("1,2,3,4,5"));
	}

	@Test
	void testNewlineDelimiter_ReturnsSum() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(6, calculator.Add("1\n2,3"));
	}

	@Test
	void testCustomDelimiter_ReturnsSum() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(3, calculator.Add("//;\n1;2"));
		assertEquals(10, calculator.Add("//#\n1#2#3#4"));
	}


	@Test
	void testNegativeNumber_ThrowsException() {
		StringCalculator calculator = new StringCalculator();
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.Add("1,-2,3"));
		assertEquals("negatives not allowed: [-2]", exception.getMessage());
	}
	@Test
	void testMultipleNegatives_ThrowsException() {
		StringCalculator calculator = new StringCalculator();
		Exception exception = assertThrows(IllegalArgumentException.class, () -> calculator.Add("1,-2,-3"));
		assertEquals("negatives not allowed: [-2, -3]", exception.getMessage());
	}

	@Test
	void testNumbersGreaterThan1000_IgnoredInSum() {
		StringCalculator calculator = new StringCalculator();
		assertEquals(2, calculator.Add("2,1001"));
		assertEquals(1002, calculator.Add("1000,2"));
	}

	@Test
	void testGetCalledCount_ReturnsCorrectCount() {
		// Arrange
		StringCalculator calculator = new StringCalculator();

		// Act
		calculator.Add("1,2"); // Call Add() once

		// Assert
		assertEquals(2, calculator.getCalledCount()); // Expect GetCalledCount() to return 2
	}

}
