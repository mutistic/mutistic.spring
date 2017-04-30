package com.chap01;

import org.junit.Test;
import static org.mockito.Mockito.*;
import com.chap01.assist.Quest;

/**
 * @program 程序清单1.4 - P31
 * @description 使用 JUnit + Mockito 测试 调用BraveKnight.embarOnQuest()
 * @author YC.Yin 
 * @date 2017-4-20
 */
public class BraveKnightTest {

	@Test
	public void knightShouldEmbarkOnQuest() {
		// 使用 org.mockito.Mockito.mock() 创建接口的 mock实现-提供测试
		Quest mockQuest = mock(Quest.class); 
		BraveKnight knight = new BraveKnight(mockQuest); 
		knight.embarOnQuest();
		
		/**
		 * 使用 org.mockito.Mockito.verify() 验证 Quest.embark()方法被是否被调用了一次
		 *  如果调用次数不等于 times(1) 则 会抛出 Wanted 1 time等错误信息
		 */
		verify(mockQuest, times(1)).embark();
	}
	
}
