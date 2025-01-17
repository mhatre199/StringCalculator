package com.hc.calculator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class StringCalculator {

	public static void main(String[] args) {
		SpringApplication.run(StringCalculator.class, args);
	}
	private int count = 0;


	public int Add(String numbers) {
		if (numbers.isEmpty()) {
			return 0;
		}

		if (!numbers.contains(",") && !numbers.contains("\n")) {
			return Integer.parseInt(numbers);
		}

		String[] tokens = numbers.split(",|\n");
		int sum = 0;
		for (String token : tokens) {
			sum += Integer.parseInt(token);
		}
		return sum;
	}
}
