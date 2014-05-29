package com.megaeyes.fin.aop;

import org.springframework.stereotype.Component;

@Component
public class MboxTabletLog {

	
	public void log(String method,int type){
		if("addTablet".equals(method)){
			System.out.println("设备注册");
		}
	}
}
