package com.megaeyes.fin.aop;

import org.aspectj.lang.JoinPoint;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.megaeyes.fin.common.Constants;

@Component
public class MegaOpterAOP {
	
	@Autowired
	private MboxTabletLog mboxTabletLog;
	
	public MboxTabletLog getMboxTabletLog() {
		return mboxTabletLog;
	}

	public void setMboxTabletLog(MboxTabletLog mboxTabletLog) {
		this.mboxTabletLog = mboxTabletLog;
	}

	public void megaLog(JoinPoint point){
		log(point,Constants.BUSINESS_NORMAL);
	}
	
	public void exceptionLog(JoinPoint point){
		log(point,Constants.BUSINESS_EXCEPTION);
	}
	
	public void log(JoinPoint point,int type){
		String className = point.getTarget().getClass().getSimpleName();
		String method = point.getSignature().getName();
		Object[] args = point.getArgs();
		
		System.out.println(className+":"+method+":");
		
		if("TabletService".equals(className)){
			mboxTabletLog.log(method, type);
		}
	}
}
