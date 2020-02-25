package com.tmax.test.svc;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class So1Executor extends ServiceExecutor
{
	public So1Executor() {
		serviceObject = new So1();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

