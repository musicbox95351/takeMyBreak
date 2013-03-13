package net.zcmusicbox.test.util.linkedList;

/**
 * 链表中的环
 * @author zhangchao
 *
 */
public class Chain {
	//环中的数据对象
	private Object data;
	//前面的环
	private Chain previous;
	//后面的环
	private Chain next;
	
	public Chain(Object data,Chain previous,Chain next){
		this.data = data;
		this.previous = previous;
		this.next = next;
	}
	
	public Object getData(){
		return data;
	}
	
	public Chain previous(){
		return previous;
	}
	
	public Chain next(){
		return next;
	}
}
