package net.zcmusicbox.test.util.linkedList;

/**
 * �����еĻ�
 * @author zhangchao
 *
 */
public class Chain {
	//���е����ݶ���
	private Object data;
	//ǰ��Ļ�
	private Chain previous;
	//����Ļ�
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
