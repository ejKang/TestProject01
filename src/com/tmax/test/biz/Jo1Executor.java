package com.tmax.test.biz;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class Jo1Executor extends ServiceExecutor
{
	public Jo1Executor() {
		serviceObject = new Jo1();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

