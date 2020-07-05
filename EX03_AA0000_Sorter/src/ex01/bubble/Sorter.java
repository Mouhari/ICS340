package ex01.bubble;

public class Sorter {
	/**
	 * Sorts the contents of the provided array using the dreaded bubblesort algorithm
	 * @param <T> Class of items to be sorted
	 * @param items array of items to be sorted
	 */
	public static <T extends Comparable<T>> void sort(T[] items) {
		for (int i = 0; i < items.length; i++) {
			for (int j = items.length - 1; j > i; j--) {
				if (items[j].compareTo(items[j -1]) < 0) {
					T temp = items[j];
					items[j] = items[j -1];
					items[j - 1] = temp;
				}
			}
		}
	}
}
