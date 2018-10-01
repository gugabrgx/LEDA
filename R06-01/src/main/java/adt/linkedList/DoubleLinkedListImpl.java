package adt.linkedList;

public class DoubleLinkedListImpl<T> extends SingleLinkedListImpl<T> implements
		DoubleLinkedList<T> {

	protected DoubleLinkedListNode<T> last;

    public DoubleLinkedListImpl() {
        this.head = new DoubleLinkedListNode<T>();
        if (head instanceof DoubleLinkedList<?>) {
            this.last = (DoubleLinkedListNode<T>) head;
        }
    }


	@Override
	public void insertFirst(T element) {
        /* Erro de cast */
        DoubleLinkedListNode<T> newHead = new DoubleLinkedListNode<T>(
                element,
                (DoubleLinkedListNode<T>) head,
                new DoubleLinkedListNode<T>()
        );
        head.previous = newHead;
        if (head.isNIL()) {
            last = newHead;
        }
        head = newHead;
	}

	@Override
	public void removeFirst() {
        if (!head.isNIL()) {
            this.head = head.next;
            if (head.isNIL()) {
                last = (DoubleLinkedListNode<T>) head;
            }
            /* Erro de cast */
            ((DoubleLinkedListNode<T>) head).previous = new DoubleLinkedListNode<T>();
        }
	}

	@Override
	public void removeLast() {
        /* Erro de cast */
	    if (!last.isNIL()) {
	        last = last.previous;
	        if (last.isNIL()) {
	            head = last;
            }
            last.next = new DoubleLinkedListNode<T>();
        }
	}

	public DoubleLinkedListNode<T> getLast() {
		return last;
	}

	public void setLast(DoubleLinkedListNode<T> last) {
		this.last = last;
	}

}
