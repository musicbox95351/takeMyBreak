package net.zcmusicbox.test.util.http;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class HttpVisiter {


	/**
	  * 通过http方式获取返回的数据
	  *
	  * @param url
	  *            请求地址
	  * @param requestData
	  *            请求数据
	  * @param charset
	  *            字符集编码
	  * @return
	  * @throws Exception
	  */
	 public static String post(String urlStr, String requestData, String charset)
	   throws Exception {
	  URL url = null;
	  HttpURLConnection conn = null;
	  ByteArrayOutputStream byteArray = null;
	  String temp;
	  try {
	   url = new URL(urlStr);
	   conn = (HttpURLConnection) url.openConnection(); // 打开，创建Connection对象

	   conn.setRequestMethod("GET"); // 设定请求方式为POST
	   conn.setDoOutput(true); // 一定要设为true,因为要发送数据
	   // 下面开始设定Http头
	   // conn.setRequestProperty("Content-Type",
	   // "multipart/form-data; boundary=Bounday---");
	   conn.setRequestProperty("Content-Type", "text/plain;charset=utf-8");
	   conn.setRequestProperty("Cache-Control", "no-cache");
	   conn.setRequestProperty("Connection", "close");
	   conn.setConnectTimeout(60000);
	   // 传送送据
	   OutputStream buf = conn.getOutputStream();
	   buf = new BufferedOutputStream(buf);
	   OutputStreamWriter out = new OutputStreamWriter(buf);
	   out.write(requestData);
	   out.flush(); // 这个一定要,清空缓存，发送数据
	   out.close();

	   // 接收数据
	   InputStream in = conn.getInputStream();
	   byteArray = new ByteArrayOutputStream(in.available());
	   byte[] b = new byte[8192];
	   int len = -1;
	   while ((len = in.read(b)) != -1) {
	    byteArray.write(b, 0, len);
	   }
	   in.close();
	   temp = byteArray.toString(charset);
	  } catch (Exception e) {
	   throw e;
	  } finally {
	   if (conn != null) {
	    conn.disconnect();
	   }
	  }
	  return temp;
	 }

	 public static void main(String[] args)throws Exception{
		 //String result = post("m.weather.com.cn/data5/city281601.xml","","UTF-8");
		 
//		 URL my_url = new URL("http://m.weather.com.cn/data5/city28.xml");
		 URL my_url = new URL("http://m.weather.com.cn/data/101281601.html");
		 BufferedReader br = new BufferedReader(new InputStreamReader(my_url.openStream(),"UTF-8"));
		 String strTemp = "";
		 while(null != (strTemp = br.readLine())){
				 System.out.println("["+strTemp+"]");
		 }

	 }
}
