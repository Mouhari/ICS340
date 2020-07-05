package ex01.insertion;

public class Sorter {
	/**
	 * Sorts the contents of the provided array using the insertionsort algorithm
	 * @param <T> Class of items to be sorted
	 * @param items array of items to be sorted
	 */
	public static <T extends Comparable<T> > void sort(T [] items) {
		for (int j = 1; j < items.length; j++) {
			T key = items[j];
			int i = j - 1;
			for (; i >= 0 && items[i].compareTo(key) > 0; i--) {
				items[i + 1] = items[i];
			}
			items[i + 1] = key;
		}
	}
}
