package net.zcmusicbox.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Judger {
	//����
	public static final String DIGITAL = "^\\d+$";
	//������
	public static final String DIGITAL_POSATIVE = "^[1-9]\\d*$";
	//������
	public static final String DIGITAL_NEGATIVE = "^-[1-9]\\d*$";
	//��λС��(�����С����)
	public static final String DECIMAL_TWO_STRICT = "^[1-9]\\d*\\.d{1,2}$";
	//��λС��(�ɲ���С����)
	public static final String DECIMAL_TWO = "^([1-9]\\d*)||([1-9]\\d*\\.d{1,2})$";
	/**
	 * ���һ���ַ����Ƿ����Ԥ����������ʽ
	 * @param reg ������ʽ
	 * @param target Ҫ����ɫ�ַ���
	 * @return
	 */
	public static boolean match(String reg,String target){
		if(reg == null){
			return false;
		}
		Pattern pat = Pattern.compile(reg);
		Matcher mat = pat.matcher(target);
		return mat.find();
	}
	
	public static void main(String args[]){
		System.out.println(Judger.match("^[1-9]\\d{0,7}$", ""));
	}
}
