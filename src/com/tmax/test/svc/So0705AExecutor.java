package com.tmax.test.svc;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class So0705AExecutor extends ServiceExecutor
{
	public So0705AExecutor() {
		serviceObject = new So0705A();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

