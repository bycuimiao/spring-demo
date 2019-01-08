package com.bycuimiao.temp;

import java.util.ArrayList;
import java.util.List;

/**
 * TODO completion javadoc.
 *
 * @author cuimiao
 * @since 01 January 2019
 */
public class Temp {
	public static void main(String[] args) {
		final List<String> list = new ArrayList<>();
		List<String> list2 = new ArrayList<>();
		list2.add("");
		list2.add("");
		list.addAll(list2);
		System.out.println(list.size());
	}
}
