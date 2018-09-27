package adt.queue;

public class QueueImpl<T> implements Queue<T> {

	private T[] array;
	private int tail;

	@SuppressWarnings("unchecked")
	public QueueImpl(int size) {
		array = (T[]) new Object[size];
		tail = -1;
	}

    @Override
    public void enqueue(T element) throws QueueOverflowException {
        if (!isFull()) {
            array[++tail] = element;
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
            tail--;
        } else {
            throw new QueueUnderflowException();
        }
        return retorno;
    }

    @Override
    public T head() {
        return array[0];
    }

    @Override
    public boolean isEmpty() {
        return tail == -1;
    }

    @Override
    public boolean isFull() {
        return tail == array.length-1;
    }

    private void shiftLeft() {
        for (int i = 1; i < array.length; i++) {
            array[i-1] = array[i];
        }
    }
}
