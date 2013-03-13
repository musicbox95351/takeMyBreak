package net.zcmusicbox.util.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Judger {
	//数字
	public static final String DIGITAL = "^\\d+$";
	//正整数
	public static final String DIGITAL_POSATIVE = "^[1-9]\\d*$";
	//负整数
	public static final String DIGITAL_NEGATIVE = "^-[1-9]\\d*$";
	//两位小数(必须带小数点)
	public static final String DECIMAL_TWO_STRICT = "^[1-9]\\d*\\.d{1,2}$";
	//两位小数(可不带小数点)
	public static final String DECIMAL_TWO = "^([1-9]\\d*)||([1-9]\\d*\\.d{1,2})$";
	/**
	 * 检查一个字符串是否符合预定的正则表达式
	 * @param reg 正则表达式
	 * @param target 要检验色字符串
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
