package com.tmax.prodesign.test.so;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class Sotest1Executor extends ServiceExecutor
{
	public Sotest1Executor() {
		serviceObject = new Sotest1();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

