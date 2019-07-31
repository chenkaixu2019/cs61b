
public class LinkedListDeque<T> {
	private int size = 0;
	private IntNode sentinel;
	public class IntNode {
		public T item;
		public IntNode next;
		public IntNode prev;

		public IntNode(T i, IntNode n, IntNode p) {
			this.item = i;
			this.next = n;
			this.prev = p;
		}

	}
	
	  public LinkedListDeque(){
		    this.sentinel = new IntNode(null, null, null);
		    this.sentinel.prev = this.sentinel;
		    this.sentinel.next = this.sentinel;
		  }

	
	public void addFirst(T item) {
		IntNode newNode = new IntNode(item, this.sentinel.next, this.sentinel);
	    this.sentinel.next.prev = newNode;
	    this.sentinel.next = newNode;
	    size++;

	}

	public void addLast(T item) {
	    IntNode newNode = new IntNode(item, this.sentinel, this.sentinel.prev);
	    sentinel.prev.next = newNode;
	    sentinel.prev = newNode;
	    size ++;
	}

	public boolean isEmpty() {
		return size == 0;
	}

	public int size() {
		return size;
	}

	public void printDeque() {
	    IntNode p = this.sentinel.next;
	    while(true){
	        System.out.print(p.item.toString() + " ");
	        if(p == sentinel.prev) {
	            break;
	        }
	        p = p.next;
	    }
	}


	public T removeFirst() {
	    if(sentinel.next == null){
	        return null;
	    }
	    T item = sentinel.next.item;
		sentinel.next = sentinel.next.next;
		sentinel.next.prev = sentinel;
		size--;
		return item;
	}

	public T removeLast() {
	    if(sentinel.prev == null){
	        return null;
	    }
		T item = sentinel.prev.item;
		sentinel.prev = sentinel.prev.prev;
		sentinel.prev.next = this.sentinel;
		size --;
		return item;
		

	}

	public T get(int index) {
		if(this.size() == 0) {
			return null;
		}else{
		       IntNode p = this.sentinel.next;
		       while(index != 0 ){
		         if(p.next == this.sentinel){
		           return null;
		         }
		         p = p.next;
		         index --;
		       }

		       return p.item;
		     }
		}
}
