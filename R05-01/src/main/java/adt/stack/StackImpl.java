package adt.stack;

import java.util.Arrays;

public class StackImpl<T> implements Stack<T> {

	private T[] array;
	private int top;

	@SuppressWarnings("unchecked")
	public StackImpl(int size) {
		this.array = (T[]) new Object[size];
		this.top = -1;
	}

	@Override
	public T top() {
	    T result;
	    if (isEmpty()) {
	        result = null;
        } else {
	        result = this.array[top];
        }
	    return result;
	}

	@Override
	public boolean isEmpty() {
        return this.top == -1;
	}

    @Override
    public boolean isFull() {
        return this.top == this.array.length - 1;
    }

    @Override
    public void push(T element) throws StackOverflowException {
        if (isFull()) throw new StackOverflowException();
        if (element != null) {
            this.array[++this.top] = element;
        }
    }

	@Override
	public T pop() throws StackUnderflowException {
        T result;
        if (!isEmpty()) {
            result = this.array[this.top];
            this.array = Arrays.copyOfRange(this.array, 0, top-1);
        } else {
	        throw new StackUnderflowException();
        }
	    return result;







	}

}
