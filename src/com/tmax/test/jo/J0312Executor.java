package com.tmax.test.jo;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class J0312Executor extends ServiceExecutor
{
	public J0312Executor() {
		serviceObject = new J0312();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

