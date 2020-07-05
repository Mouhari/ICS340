/* Author: Ralph A. Foy
 * Class : ICS340-01 Summer 2020
 * 
 *       Copyright (c) 2020 
 *       Authorization is given to students enrolled in the course to reproduce 
 *       this material exclusively for their own personal use.
 */
package ex03.heap;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * An ICS340 - worthy heapsort implementation based loosely on Cormen(2017).
 * Note: since Java provides a heap via the {@link PriorityQueue} class, there
 * is no need for us to hand-roll them other than personal edification (or
 * self-inflicted misery).
 * 
 * @author rfoy
 *
 */
public class Sorter {

	static class Heap<T extends Comparable<T>> {
		private PriorityQueue<T> items;

		public Heap() {
			super();
			items = new PriorityQueue<T>();
		}

		public Heap(T[] items) {
			this();
			this.items.addAll(Arrays.asList(items));
		}

		private T removeTop() {
			// TODO Auto-generated method stub
			return items.remove();
		}

		@Override
		public String toString() {
			return items.toString();
		}
	}

	/**
	 * Sorts array of <code>items</code> using an implementation of heapsort
	 * @param <T> class of items to be sorted, must extend {@link Comparable}
	 * @param items items to be sorted. Cannot be null.
	 */
	public static <T extends Comparable<T>> void sort(T[] items) {
		var heap = new Heap<T>(items);
		for (int i = 0; i < items.length; i++) {
			items[i] = heap.removeTop();
		}
	}

}
