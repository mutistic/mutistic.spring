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
	public final static String LINE_LONG = "------------------------";
	public final static String LINE_LONG_LN = "\n\n" + LINE_LONG;
	public final static String LINE_SHORT = "----------------";
	public final static String LINE_SHORT_LN = "\n" + LINE_SHORT;

	public static void println() {
		System.out.println();
	}

	public static void printOne(String str) {
		System.out.println(LINE_LONG_LN + (str == null ? "" : str));
	}

	public static void printTwo(String str, Object obj) {
		System.out.println(LINE_SHORT_LN + (str == null ? "" : str) + (obj == null ? "" : T_LEFT + obj + T_RIGTH));
	}

	public static void printThree(String str, Object obj) {
		System.out.println(LINE_SHORT + (str == null ? "" : str) + (obj == null ? "" : T_LEFT + obj + T_RIGTH));
	}

}
