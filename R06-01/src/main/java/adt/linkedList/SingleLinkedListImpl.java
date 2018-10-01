package adt.linkedList;

import java.util.ArrayList;
import java.util.List;

public class SingleLinkedListImpl<T> implements LinkedList<T> {

	protected SingleLinkedListNode<T> head;

	public SingleLinkedListImpl() {
		this.head = new SingleLinkedListNode<T>();
	}

	@Override
	public boolean isEmpty() {
		if (this.head.isNIL()) {
		    return true;
        } else {
		    return false;
        }
	}

    @Override
	public int size() {
        int size = 0;
        SingleLinkedListNode<T> aux = head;
        while (!aux.isNIL()) {
            size++;
            aux = aux.next;
        }
        return size;
	}

	@Override
	public T search(T element) {
        SingleLinkedListNode<T> current = head;
	    while (!current.isNIL()) {
	        if (current.data == element) {
	            return current.data;
            }
            current = current.next;
        }
        return null;
	}

	@Override
	public void insert(T element) {
        SingleLinkedListNode<T> auxHead = this.head;
	    if (this.head.isNIL()) {
            SingleLinkedListNode<T> newHead = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
	        newHead.next = this.head;
	        this.head = newHead;
        } else {
	        while (!auxHead.next.isNIL()) {
	            auxHead = auxHead.next;
            }
            SingleLinkedListNode<T> newNode = new SingleLinkedListNode<T>(element, new SingleLinkedListNode<T>());
	        newNode.next = auxHead.next;
	        auxHead.next = newNode;
        }
	    
	}

	@Override
	public void remove(T element) {
	    
	    /* VAI DAR RUIM */
	    
        SingleLinkedListNode<T> previous = null;
        if (this.head.data == element) {
            this.head = this.head.next;
        } else {
            SingleLinkedListNode<T> aux = this.head;
            while (!aux.isNIL() && aux.data != element) {
	            previous = aux;
	            aux = aux.next;
            }
            if (!aux.isNIL()) {

                assert previous != null;
                previous.next = aux.next;
            }
        }
	}

	@Override
	public T[] toArray() {
        List<T> lista = new ArrayList<T>();

        SingleLinkedListNode<T> aux = head;
        int count = 0;
        while (!aux.isNIL()) {
            lista.add(count, aux.data);
            aux = aux.next;
            count++;
        }
        return (T[]) lista.toArray();

	}

	public SingleLinkedListNode<T> getHead() {
		return head;
	}

	public void setHead(SingleLinkedListNode<T> head) {
		this.head = head;
	}

}
