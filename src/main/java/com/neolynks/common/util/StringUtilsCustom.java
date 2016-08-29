/**
 * 
 */
package com.neolynks.common.util;

import java.util.Random;

//import org.apache.commons.lang3.text.StrTokenizer;

/**
 * Created by nitesh.garg on Nov 18, 2015
 *
 */
public class StringUtilsCustom {

	public static final Random newR = new Random(1000L);
/*	
	public static List<String> convertStringToTokens(String data) {
		return new StrTokenizer(data, ",").getTokenList();
	}
	*/
	public static String extractFileName(String fileName) {
		return fileName.substring(fileName.lastIndexOf("/")+1);
	}
	
	public static Boolean isChanged(String oldValue, String newValue) {
		
		if(oldValue == null && newValue == null)
			return false;
		
		return !(newValue.equals(oldValue));
	}

}
