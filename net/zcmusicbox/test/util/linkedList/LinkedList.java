package net.zcmusicbox.test.util.linkedList;

/**
 * 普通链表接口
 * @author zhangchao
 *
 * @param <T> 链表对象
 */
public interface LinkedList<Chain> {
	public void add(Chain data );
	
	public Chain find(int position);
	
	public int size();
	
	public int remove();
}
