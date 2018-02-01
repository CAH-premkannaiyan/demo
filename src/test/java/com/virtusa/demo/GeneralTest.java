package com.virtusa.demo;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

import org.junit.Test;

import com.virtusa.demo.web.rest.Product;

public class GeneralTest {

	@Test
	public void forEachTest() {
		// creating sample Collection
		List<Integer> myList = new ArrayList<Integer>();
		for (int i = 0; i < 10; i++)
			myList.add(i);
		/*
		 * myList.forEach(Consumer<Integer> action);
		 * 
		 * }
		 */
	}

	@Test
	public void streamTest() {
		List<Integer> myList = new ArrayList<>();
		for (int i = 0; i < 100; i++)
			myList.add(i);

		// sequential stream
		Stream<Integer> sequentialStream = myList.stream();

		// parallel stream
		Stream<Integer> parallelStream = myList.parallelStream();

		// using lambda with Stream API, filter example
		Stream<Integer> highNums = parallelStream.filter(p -> p > 90);
		// using lambda in forEach
		highNums.forEach(p -> System.out.println("High Nums parallel=" + p));

		Stream<Integer> highNumsSeq = sequentialStream.filter(p -> p > 90);
		highNumsSeq.forEach(p -> System.out
				.println("High Nums sequential=" + p));
	}

	@Test
	public void consumerTest() {
		List<Product> products = new ArrayList<Product>();
		products.add(new Product(1L, "Java"));
		products.add(new Product(2L, "Spring"));

		Consumer<Product> cons = (Product p) -> System.out.println("Name:"
				+ p.getName() + ";Id:" + p.getId());

		products.forEach(cons);

		products.forEach(p -> System.out.println(p.getName()));

		products.forEach(Product::printAll);

		ConsumerObject consObj = new ConsumerObject();
		products.forEach(consObj);
	}

	@Test
	public void filesLinesTest() {
		try {
			Files.lines(Paths.get("c://Mails//data.txt")).map(s -> s.trim())
					.filter(s -> !s.isEmpty()).forEach(System.out::println);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

class ConsumerObject implements Consumer<Product> {

	public void accept(Product t) {
		System.out.println("Name:" + t.getName() + ";id:" + t.getId());

	}

}
