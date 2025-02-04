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
		count++;
		if (numbers.isEmpty()) {
			return 0;
		}

		if (!numbers.contains(",") && !numbers.contains("\n")) {
			return Integer.parseInt(numbers);
		}

		String delimiter = ",|\n";
		if (numbers.startsWith("//")) {
			int delimiterEnd = numbers.indexOf("\n");
			delimiter = numbers.substring(2, delimiterEnd); // Extract custom delimiter
			numbers = numbers.substring(delimiterEnd + 1); // Remove delimiter declaration from input
		}
		String[] tokens = numbers.split(delimiter); // Split by the identified delimiter(s)
//		String[] tokens = numbers.split(",|\n");

		int sum = 0;
		List<Integer> negatives = new ArrayList<>();

		for (String token : tokens) {
			int number = Integer.parseInt(token);
			if (number < 0) {
				negatives.add(number); // Collect negative numbers
			} else {
				sum += number;
			}
		}


		if (!negatives.isEmpty()) {
			throw new IllegalArgumentException("negatives not allowed: " + negatives);
		}
		return sum;
	}


	public int getCalledCount() {
		return count;
	}



	}




