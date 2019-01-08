package com.bycuimiao.demo;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 04 January 2019
 */
public class Temp {
	public static void main(String[] args) {
		System.out.println(isLegalTitle("因迈数字科技（上05）有限公司"));
	}

	private static boolean isLegalTitle(String checkedString){
		//判断空格和特殊字符
		/*String exp = "[ |\uF880：\\s]";
		Pattern regex = Pattern.compile(exp);
		Matcher matcher = regex.matcher(checkedString);
		//判断数字
		Pattern p = Pattern.compile(".*\\d+.*");
		return !(matcher.find() || p.matcher(checkedString).find());*/
		Map<String,String> set = new HashMap();
		System.out.println(set.put("hello","a"));
		System.out.println(set.put("hello","a"));
		return false;
	}
}
