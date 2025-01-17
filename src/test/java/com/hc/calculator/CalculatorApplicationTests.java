package com.hc.calculator;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

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
}
