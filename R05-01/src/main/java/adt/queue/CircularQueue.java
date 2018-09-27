package adt.queue;

public class CircularQueue<T> implements Queue<T> {

	private T[] array;
	private int tail;
	private int head;
	private int elements;

	public CircularQueue(int size) {
		this.array = (T[]) new Object[size];
		this.head = -1;
		this.tail = -1;
		this.elements = 0;
	}

	@Override
	public void enqueue(T element) throws QueueOverflowException {
        if (!isFull()) {
            if (isEmpty()) {
                this.head++;
            }
            if (this.tail == this.array.length) {
                this.tail = 0;
            } else {
                this.tail++;
            }
            this.array[this.tail] = element;
            this.elements++;
        } else {
            throw new QueueOverflowException();
        }
	}

    @Override
    public T head() {
        T result;
        if (isEmpty()) {
            result = null;
        } else {
            result = this.array[this.head];
        }
        return result;
    }

    @Override
    public boolean isEmpty() {
        return this.tail < 0;
    }

    @Override
    public boolean isFull() {
        return this.elements == this.array.length;
    }

	@Override
	public T dequeue() throws QueueUnderflowException {
	    T retorno;
	    if (!isEmpty()) {
	        retorno = head();
	        this.array[this.head] = null;
	        if (this.head == this.array.length-1) {
	            this.head = 0;
            } else {
	            this.head++;
            }
            this.elements--;
        } else {
	        throw  new QueueUnderflowException();
        }
	    return retorno;
	}

}
