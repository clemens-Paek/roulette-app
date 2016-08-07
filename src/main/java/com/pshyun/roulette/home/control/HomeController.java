package com.pshyun.roulette.home.control;

import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.mobile.device.Device;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@EnableAutoConfiguration
public class HomeController {
	
	@RequestMapping("/")
	public String home(Device device) {
		System.out.println("@@ device is mobile / tablet? : " + device.isMobile() + " / " + device.isTablet());
		//모바일 디바이스로 접속했다면 
		if (device.isMobile()) {
			return "mindex";
		} else if (device.isTablet()) {
			//return "tindex";
			return "mindex";
		} else {
			//return "index";
			return "mindex";
		}
	}
}
