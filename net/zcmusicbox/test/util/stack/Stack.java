package net.zcmusicbox.test.util.stack;

public interface Stack<T> {
	public void clear();
	
	public T pop();
	
	public void push(T data);
	
	public int size();
}
