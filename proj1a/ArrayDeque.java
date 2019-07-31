
public class ArrayDeque<T> {

	T[] items;
	int size;

	public ArrayDeque() {
		items = (T[]) new Object[8];
		size = 0;
	}

	private void resize(int tosize) {
		T[] a = (T[]) new Object[tosize];
		System.arraycopy(items, 0, a, 0, size);
		items = a;
	}

	public void addFirst(T item) {
		if (size == items.length) {
			resize(size * 2);
		}
		T[] a = (T[]) new Object[size];
		System.arraycopy(items, 0, a, 1, size);
		a[0] = item;
		items = a;
		size++;
	}

	public void addLast(T item) {
		if (size == items.length) {
			resize(size * 2);
		}
		items[size] = item;
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
		if ((size * 4) < items.length) {
			resize(items.length /2);
		}
		T item = items[0];
		T[] a = (T[]) new Object[size];
		System.arraycopy(items, 1, a, 0, size - 1);
		items = a;
		size--;
		return item;
	}

	public T removeLast() {
		if ((size * 4) < items.length) {
			resize(items.length /2);
		}
		T item = items[size- 1];
		size--;
		return item;
	}

	public T get(int index) {
		return items[index];

	}
}
