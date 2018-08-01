package com.mutistic.actuator;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mutistic.utils.CommonUtil;

/**
 * @program 演示 监控和度量的使用
 * @description 
 * @author mutisitic
 * @date 2018年8月1日
 */
@RestController
@RequestMapping("/testControllerByActuator/")
public class TestControllerByActuator {

	@GetMapping("showByActuator")
	public String showByActuator() {
		StringBuffer val = new StringBuffer("\n\n\n----------------------");
		val.append("演示 监控和度量的使用：");
//		http://127.0.0.1:8888/actuator/info
//		http://127.0.0.1:8888/actuator/health
		
		CommonUtil.printOne(val.toString());
		return val.toString();
	}

}
