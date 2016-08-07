package com.pshyun.reoulette.home.control;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mobile.device.Device;
import org.springframework.mobile.device.DeviceUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class HomeController {
	
	@RequestMapping("/")
	public String index(HttpServletRequest request) {
		//사용자 접근 디바이스타입에 따른 분기처리 
		Device device = DeviceUtils.getCurrentDevice(request);
		System.out.println("@@ device is mobile? : " + device.isMobile());

		//모바일 디바이스로 접속했다면 
		if (device.isMobile()) {
			return "mindex";
		} else {
			return "mindex";
		}
	}
}
