package com.mutistic.utils;

/**
 * @program 公共静态常量类
 * @description 用于声明常用的静态常量类
 * @author mutisitic
 * @date 2018年6月5日
 */
public class CommonConstant {

	public final static String T_LEFT = "【";
	public final static String T_RIGTH = "】";
	public final static String PRINT_PREF = "==========";
	public final static String PRINTLN_PREF = "\n==========";
	public final static String PRINT_LINE = "========================================";
	public final static String PRINTLN_LINE = "\n========================================";
	
	public static void println() {
		System.out.println();
	}

	public static void printLine(String str) {
		System.out.println(PRINTLN_LINE + str);
	}
	
	public static void printPref(String str, Object obj) {
		System.out.println(PRINTLN_PREF + str + T_LEFT + obj + T_RIGTH);
	}
}
