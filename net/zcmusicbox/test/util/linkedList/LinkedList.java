package net.zcmusicbox.test.util.linkedList;

/**
 * ��ͨ����ӿ�
 * @author zhangchao
 *
 * @param <T> �������
 */
public interface LinkedList<Chain> {
	public void add(Chain data );
	
	public Chain find(int position);
	
	public int size();
	
	public int remove();
}
