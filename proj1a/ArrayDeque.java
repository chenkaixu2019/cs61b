
public class ArrayDeque<T> {

	private T[] items;
	private int size;
	private int nextFirst;
	private int nextLast;

	public ArrayDeque() {
		items = (T[]) new Object[8];
		size = 0;
		nextFirst = 0;
		nextLast = 0;
	}

	private void resize(int tosize) {
		T[] a = (T[]) new Object[tosize];
		System.arraycopy(items, 0, a, 0, size);
		items = a;
	}

	private void IndexPlusOne(int i) {
		if (i == items.length - 1) {
			i = 0;
		} else {
			i++;
		}
	}

	private void IndexMinusOne(int i) {
		if (i == 0) {
			i = items.length - 1;
		} else {
			i--;
		}
	}

	public void addFirst(T item) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextFirst] = item;
		IndexMinusOne(nextFirst);
		size++;
	}

	public void addLast(T item) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[nextLast] = item;
		IndexPlusOne(nextLast);
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
		if ((size * 4) < items.length) {
			T[] a = (T[]) new Object[items.length / 2];
			if (nextLast > nextFirst) {
				System.arraycopy(items, nextFirst + 1, a, 0, size);
			} else {
				System.arraycopy(items, nextFirst + 1, a, 0, size - nextLast);
				System.arraycopy(items, 0, a, size - nextLast, nextLast);
			}
			nextFirst = items.length - 1;
			nextLast = size;
		}
		IndexPlusOne(nextFirst);
		T item = items[nextFirst];
		size--;
		return item;
	}

	public T removeLast() {
		if (size == 0) {
			return null;
		}
		
		if ((size * 4) < items.length) {
			T[] a = (T[]) new Object[items.length/2];
			if (nextLast > nextFirst) {
				System.arraycopy(items, nextFirst + 1, a, 0, size);
			}
			else {
				System.arraycopy(items, nextFirst + 1, a, 0, size-nextLast);	
				System.arraycopy(items, 0, a, size-nextLast, nextLast );
			}
			nextFirst = items.length-1;
			nextLast = size;
		}
		IndexMinusOne(nextLast);
		T item = items[nextLast];
		size--;
		return item;
	}

	public T get(int index) {
		return items[index];

	}
}
