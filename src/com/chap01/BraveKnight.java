package com.chap01;

import org.junit.Test;

import com.chap01.assist.Knight;
import com.chap01.assist.Quest;
import com.chap01.assist.RescueDamseQuest;


/**
 * @program 程序清单1.3 
 * @description 使用 Quest.embark()的对程序清单1.2进行解耦
 * @author YC.Yin 
 * @date 2017-4-20
 */
public class BraveKnight implements Knight {

	private Quest quest;
	
	public BraveKnight(Quest quest) {
		this.quest = quest;
	}
	
	public void embarOnQuest() {
		quest.embark();
		System.out.println("BraveKnight.embarOnQuest()");
	}
	
	public static void main(String[] args) {
		 new BraveKnight(new RescueDamseQuest()).embarOnQuest();
	}
	
	@Test
	public void test() {
		/**
		 * JUnit对BraveKnight测试时
		 *  1、没有默认构造器时无法使用Test
		 *  2、存在多个构造器时无法使用Test
		 *   (可以单独创建一个测试类来测试   BraveKnight.embarOnQuest() 比如 com.chap01.BraveKnightTest.com.chap01())
		 */
		new BraveKnight(new RescueDamseQuest()).embarOnQuest();
	}
	
}
