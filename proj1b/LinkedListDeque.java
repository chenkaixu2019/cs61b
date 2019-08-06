public class LinkedListDeque<T> implements Deque<T> {
	private int size = 0;
	private IntNode sentinel;

	private class IntNode {
		public T item;
		public IntNode next;
		public IntNode prev;

		public IntNode(T i, IntNode n, IntNode p) {
			this.item = i;
			this.next = n;
			this.prev = p;
		}

	}

	public LinkedListDeque() {
		this.sentinel = new IntNode(null, null, null);
		this.sentinel.prev = this.sentinel;
		this.sentinel.next = this.sentinel;
	}

	@Override
	public void addFirst(T item) {
		IntNode newNode = new IntNode(item, this.sentinel.next, this.sentinel);
		this.sentinel.next.prev = newNode;
		this.sentinel.next = newNode;
		size++;

	}

	@Override
	public void addLast(T item) {
		IntNode newNode = new IntNode(item, this.sentinel, this.sentinel.prev);
		sentinel.prev.next = newNode;
		sentinel.prev = newNode;
		size++;
	}

	@Override
	public boolean isEmpty() {
		return size == 0;
	}

	@Override
	public int size() {
		return size;
	}

	@Override
	public void printDeque() {
		IntNode p = this.sentinel.next;
		while (true) {
			System.out.print(p.item.toString() + " ");
			if (p == sentinel.prev) {
				break;
			}
			p = p.next;
		}
	}

	@Override
	public T removeFirst() {
		if (sentinel.next == null || sentinel.next == sentinel) {
			return null;
		}
		T item = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size--;
		return item;
	}

	@Override
	public T removeLast() {
		if (sentinel.prev == null || sentinel.prev == sentinel) {
			return null;
		}
		T item = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = this.sentinel;
		size--;
		return item;

	}

	@Override
	public T get(int index) {
		if (this.size() == 0) {
			return null;
		} else {
			IntNode p = this.sentinel.next;
			while (index != 0) {
				if (p.next == this.sentinel) {
					return null;
				}
				p = p.next;
				index--;
			}

			return p.item;
		}
	}

	public T getRecursive(int index) {
		if (index == 0) {
			return this.sentinel.next.item;
		}
		IntNode p = this.sentinel.next;
		return getHelper(index, p);
	}

	private T getHelper(int index, IntNode p) {
		if (index == 0) {
			return p.item;
		} else {
			p = p.next;
			return this.getHelper(index - 1, p);
		}

	}
}
