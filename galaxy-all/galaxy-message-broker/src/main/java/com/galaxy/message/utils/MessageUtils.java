/**
 * 
 */
package com.galaxy.message.utils;


/**
 * @author luolishu
 *
 */
public abstract class MessageUtils {
	
	public static String generateQueueId(Long userId){
		return "user/"+userId+"";
	}

}
