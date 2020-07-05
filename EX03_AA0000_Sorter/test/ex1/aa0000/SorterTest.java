package ex1.aa0000;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

import java.util.Arrays;
import java.util.Random;
import java.util.logging.Logger;

import org.junit.jupiter.api.Test;

import ex01.insertion.Sorter;



class SorterTest {
	private static long SEED = 20200521001L;

	private static Random RAND = new Random(SEED);

	/*
	 * reusable test helper method to spare us from repeated code. greatly
	 * simplifies creating test cases and reduces the chance of creating a bug
	 * 
	 * @param items -- Comparable thingies to be sorted
	 */
	@SafeVarargs // the compiler can't be sure that this is legit, but we know our code. More of
					// a Java quirk.
	private static <T extends Comparable<T>> void testSort(T... items) {
		T[] exp = items.clone();

		Sorter.sort(items);
		Arrays.sort(exp);
		assertArrayEquals(exp, items);
	}

	/*
	 * Returns an array of <code>n</code> numbers between <code>min</code> and
	 * <code>max</code>
	 */
	private Integer[] genNumsBetween(int n, int min, int max) {
		var nums = new Integer[n];

		for (int i = 0; i < n; i++) {
			nums[i] = getNumBetween(min, max);
		}

		return nums;
	}

	/*
	 * Generates a random number between <code>min</code> and <code>max</code>
	 */
	private int getNumBetween(int min, int max) {
		return min + RAND.nextInt(max - min);
	}

	@Test
	void test0() {
		// test an empty array -- the "0" boundary case
		testSort(new Integer[] {}); // note: varags are the equivalent of an array parameter.
	}

	@Test
	void test1() {
		// test a one-element array -- the "1" boundary case
		testSort(42);
	}

	@Test
	void test2InOrder() {
		testSort(11, 42);
	}

	@Test
	void test2NotInOrder() {
		testSort(42, 11);
	}

	@Test
	void testRandomNumbers() {
		int n = 1_000_000; // getNumBetween(100_000, 1_000_000);
		int min = 1000;
		int max = 9999;
		Integer[] numbers = genNumsBetween(n, min, max);
		Logger.getLogger(SorterTest.class.getName())
				.info(String.format("Sorting %,d numbers between %d and %d", n, min, max));
		testSort(numbers);
	}
}
