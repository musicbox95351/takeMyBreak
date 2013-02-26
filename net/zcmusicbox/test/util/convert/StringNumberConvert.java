package net.zcmusicbox.test.util.convert;

public class StringNumberConvert {
	public static void main(String args[]){
		char versionInfo[] = Integer.toHexString(32).toCharArray();
		for(int i=0;i<versionInfo.length;i++){
			System.out.println(versionInfo[i]);
		}
	}
}
