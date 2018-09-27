package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		this.array = (T[]) new Object[size];
		this.tail = -1;
	}

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (!isFull()) {
            if (element != null) {
                this.array[++this.tail] = element;
            }
        } else {
            throw new QueueOverflowException();
        }
    }

    @Override
    public T dequeue() throws QueueUnderflowException {
        T retorno;
        if (!isEmpty()) {
            retorno = head();
            shiftLeft();
            this.tail--;
        } else {
            throw new QueueUnderflowException();
        }
        return retorno;
    }

    private void shiftLeft() {
        for (int i = 1; i < this.array.length; i++) {
            this.array[i-1] = this.array[i];
        }
    }

    @Override
    public boolean isEmpty() {
        return this.tail <= 0;
    }

    @Override
    public boolean isFull() {
        return this.tail == this.array.length-1;
    }

    @Override
    public T head() {
        T result;
        if (isEmpty()) {
            result = null;
        } else {
            result = this.array[0];
        }
        return result;
    }
}
