package ex01.selection;

/**
 * Sorts the provided array using the Selection Sort algorithm
 * 
 * SELECTION-SORT(A) PRECONDITION: A is not null; for i : 1 .. (A.length - 1)
 * int minIndex = i for j : i + 1 .. A.length if (A[j] < A[minIndex]) then
 * minIndex = j tmp = A[i] A[i] = A[minIndex] A[minIndex] = tmp
 * 
 * @author rfoy
 *
 */
public class Sorter {
	
	/**
	 * Sorts the contents of the provided array using the selectionsort algorithm
	 * @param <T> Class of items to be sorted
	 * @param items array of items to be sorted
	 */
	public static <T extends Comparable<T>> void sort(T[] items) {
		if (items == null) {
			throw new NullPointerException("array cannot be null");
		}

		for (int i = 0; i < items.length - 1; i++) {
			int minIndex = i;
			for (int j = i + 1; j < items.length; j++) {
				if (items[j].compareTo(items[minIndex]) < 0) {
					minIndex = j;
				}
			}
			swap(items, i, minIndex);
		}
	}

	// swaps values in the array if the positions are different
	private static <T extends Comparable<T>> void swap(T[] values, int sortPos, int minPos) {
		if (sortPos != minPos) {
			T tmp = values[sortPos];
			values[sortPos] = values[minPos];
			values[minPos] = tmp;
		}
	}
}
