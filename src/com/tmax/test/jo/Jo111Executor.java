package com.tmax.test.jo;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class Jo111Executor extends ServiceExecutor
{
	public Jo111Executor() {
		serviceObject = new Jo111();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

