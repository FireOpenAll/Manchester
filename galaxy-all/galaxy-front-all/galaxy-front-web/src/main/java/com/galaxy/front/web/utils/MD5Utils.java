package com.galaxy.front.web.utils;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/*author:huangshanqi
 *time  :2014年10月6日 上午9:38:58
 *email :hsqmobile@gmail.com
 */
public class MD5Utils {
	/**
	 * MD5加密类
	 */
	

	/**
	 * MD5指纹获取
	 * @param original
	 * @return byte[]
	 */
	public static byte[] encode2bytes(String original){
		byte[] result = null;
		MessageDigest messageDigest;
		try {
			messageDigest = MessageDigest.getInstance("MD5");
			messageDigest.reset();
			
			//加密处理
			original = addMessage(original);
			
			messageDigest.update(original.getBytes("utf-8"));
			result = messageDigest.digest();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return result;
		
	}
	
	/*外部调用*/
	public static String encode2String(String original){
		byte[] encode = encode2bytes(original);
		
		StringBuffer stringBuffer = new StringBuffer();
		for(byte b:encode){
			String hexsString = Integer.toHexString(0xFF & b);
			if (hexsString.length() == 1) {
				stringBuffer.append('0');
			}
			stringBuffer.append(hexsString);
		}
		return stringBuffer.toString();
	}

	/**
	 * 验证MD5加密是否正确
	 * @param original
	 * @param encodeString
	 * @return
	 */
	public static boolean verifyMD2(String original,String encodeString){
		if (encodeString.equals(encode2String(original))) {
			return true;
		}
		return false;
	}
	
	
	private static String addMessage(String original) {
		/**
		 * 自定义加密处理
		 */
		// TODO Auto-generated method stub
		StringBuilder stringBuilder = new StringBuilder("");
		stringBuilder.append(original);
		stringBuilder.append("|");
		stringBuilder.append("galaxy");
		return stringBuilder.toString();
	}
}
