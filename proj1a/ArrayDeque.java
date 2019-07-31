
public class ArrayDeque<T> {

	private T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque() {
		items = (T[]) new Object[8];
		size = 0;
		nextFirst = 0;
		nextLast = 1;
	}

	private void resize(int tosize) {
		T[] a = (T[]) new Object[tosize];
		int first = IndexPlusOne(nextFirst);
		int i = 0;
		while (i < size) {
			a[i] = items[first];
			first = IndexPlusOne(first);
			i++;
		}
		items = a;
		nextFirst = items.length - 1;
		nextLast = size;
	}

	private int IndexPlusOne(int i) {
		if (i == items.length - 1) {
			i = 0;
		} else {
			i++;
		}
		return i;
	}

	private int IndexMinusOne(int i) {
		if (i == 0) {
			i = items.length - 1;
		} else {
			i--;
		}
		return i;
	}

	public void addFirst(T item) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextFirst] = item;
		nextFirst = IndexMinusOne(nextFirst);
		
		size++;
	}

	public void addLast(T item) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextLast] = item;
		nextLast = IndexPlusOne(nextLast);
		size++;
	}

	public boolean isEmpty() {
		return size == 0;

	}

	public int size() {
		return size;
	}

	public void printDeque() {
		int s = 0;
		while (s < size) {
			System.out.print(items[s].toString() + " ");
			s++;
		}
	}

	public T removeFirst() {
		if (size == 0) {
			return null;
		}
		nextFirst = IndexPlusOne(nextFirst);
		T item = items[nextFirst];
		size--;
		if ((size * 4) < items.length) {
			resize(items.length / 2);
		}
		return item;
	}

	public T removeLast() {
		if (size == 0) {
			return null;
		}
		nextLast = IndexMinusOne(nextLast);
		T item = items[nextLast];
		size--;
		if ((size * 4) < items.length) {
			resize(items.length / 2);
		}
		return item;
	}

	public T get(int index) {
		if (size == 0) {
			return null;
		}
		int first = IndexPlusOne(nextFirst);

		while (index > 0) {
			first = IndexPlusOne(first);
			index--;
		}
		return items[first];
	}
}
