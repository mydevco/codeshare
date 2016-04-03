package com.mydevco.javabp.language;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class FunctionalInterfaceExample {

	@FunctionalInterface
	public interface NumberParser {
		public List<Double> parseNumbers(String s, String pattern);

		default public String getName() {
			return "NumberParser is a functional interface";
		}
	}

	public List<Double> getPrasedNumbers(String s, String pattern,
			NumberParser np) {
		return np.parseNumbers(s, pattern);
	}

	public static void main(String[] args) {

		NumberParser numParse = new NumberParser() {

			@Override
			public List<Double> parseNumbers(String s, String pattern) {
				Pattern p = Pattern.compile(pattern);
				Matcher m = p.matcher(s);
				List<String> strings = new ArrayList();

				while (m.find()) {
					strings.add(m.group());
				}

				Double[] numbers = new Double[strings.size()];

				List<Double> doubles = strings.stream()
						.mapToDouble(str -> Double.parseDouble(str)).boxed()
						.collect(Collectors.toList());
				return doubles;
			}

		};

		FunctionalInterfaceExample example = new FunctionalInterfaceExample();

		List<Double> parsedDoubles = example
				.getPrasedNumbers(
						"5 fingers of lengthsn 2.4, 3.2, 3.5, 4.1, 2.9 iches in each hand and 2 hands in 1 body",
						"\\d+(\\.\\d{1,2})?", numParse);

		parsedDoubles.forEach(d -> System.out.println(d));
	}

}
