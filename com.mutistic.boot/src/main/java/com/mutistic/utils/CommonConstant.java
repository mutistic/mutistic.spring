package com.mutistic.utils;

/**
 * @program 公共静态常量类
 * @description 用于声明常用的静态常量类
 * @author mutisitic
 * @date 2018年6月5日
 */
public class CommonConstant {

	public final static String PRINT_PREF = "==========";
	public final static String PRINTLN_PREF = "\n==========";
	public final static String PRINT_LINE = "========================================";

	public static void PRINTLN() {
		System.out.println();
	}

	public static void PRINTLINE() {
		System.out.println(PRINT_LINE);
	}

	public static void PRINTLINE(String str) {
		System.out.println(PRINT_LINE + str);
	}
}
