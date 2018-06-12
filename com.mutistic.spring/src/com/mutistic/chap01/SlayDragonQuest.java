package com.mutistic.chap01;

import java.io.PrintStream;

import com.mutistic.chap01.assist.Quest;

/**
 * @program 查询清单1.5 - P31
 * @description 创建 Quest 的实现类 SlayDragonQuest（其可注入到 BraveKnight 中）
 * @author YC.Yin 
 * @date 2017-4-30
 */
public class SlayDragonQuest implements Quest {

	/**
	 * java.io.PrintStream 打印流对象
	 *  将数据打印(写入)到被 PrintStream 装饰的底层字节输出流中去
	 */
	private PrintStream stream;
	
	/**
	 * SlayDragonQuest 构造器
	 * @param stream java.io.PrintStream 打印流
	 */
	public SlayDragonQuest(PrintStream stream) {
		// TODO Auto-generated constructor stub
		this.stream = stream;
	}
	
	public void embark() {
		// TODO Auto-generated method stub
		if(stream == null) {
			System.err.println("stream is null!");
		}
		/**
		 * 使用 java.io.PrintStream.println() 打印流 打印输入内容
		 */
		stream.println("Embarking on quest to slay the dragon!");
		stream.println("SlayDragonQuest.embark()");
	}

}
