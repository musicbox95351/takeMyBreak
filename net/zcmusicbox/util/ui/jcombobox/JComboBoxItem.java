package net.zcmusicbox.util.ui.jcombobox;

/**
 * 用于JComboBox的item值对象
 * @author zc
 *
 * @param <K> 
 * @param <V>
 */
public class JComboBoxItem<K,V> {
	private K key;
	private V value;
	
	public JComboBoxItem(){}
	
	public JComboBoxItem(K key,V value){
		this.key = key;
		this.value = value;
	}
	
	public String toString(){
		return value.toString();
	}

	public K getKey() {
		return key;
	}

	public void setKey(K key) {
		this.key = key;
	}

	public V getValue() {
		return value;
	}

	public void setValue(V value) {
		this.value = value;
	}
	
	
}
