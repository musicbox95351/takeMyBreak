package net.zcmusicbox.test.util.stack;

/**
 * 实现了一个简单的数组栈对象
 * @author zhangchao
 *
 * @param <T>
 */
public class ArrayStack<T> implements Stack<T>{

	private Object[] stackArray = new Object[15];
	private int size = 0;
	@Override
	public void clear() {
		stackArray = new Object[15];
		size = 0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public T pop() {
		return size > 0 ? (T)stackArray[size-1]:null;
	}

	@Override
	public void push(T data) {
		if(size == stackArray.length){
			resize();
		}
		stackArray[size] = data;
		size++;
	}

	public void resize(){
		Object[] array2 = new Object[(int) ((float)size*1.3f )  ];
		System.arraycopy(stackArray, 0, array2, 0, size);
		stackArray = array2;
	}
	
	@Override
	public int size() {
		return size;
	}
	
	public static void main(String[] args){
		ArrayStack<Object> s = new ArrayStack<Object>();
		for(int i=0;i<3000;i++){
			s.push(Integer.valueOf(i));
		}
		System.out.println(s.pop());
	}
}
