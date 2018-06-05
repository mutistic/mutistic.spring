package com.mutisitic.chap01;

import org.junit.Test;

import com.mutisitic.chap01.assist.Knight;
import com.mutisitic.chap01.assist.RescueDamseQuest;


/**
 * @program 程序清单1.2 - P29
 * @description 实现 Quest.embark()的调用
 * @author YC.Yin 
 * @date 2017-4-20
 */
public class DamselRescuingKnight implements Knight {

	private RescueDamseQuest quest;

	public DamselRescuingKnight() {
		this.quest = new RescueDamseQuest();
	}

	public void embarkOnQuest() {
		quest.embark();
		System.out.println("DamselRescuingKnight.embarkOnQuest()");
	}
	
	@Test
	public void test() {
		new DamselRescuingKnight().embarkOnQuest();
	}

}
