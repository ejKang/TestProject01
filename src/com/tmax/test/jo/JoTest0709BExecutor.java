package com.tmax.test.jo;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class JoTest0709BExecutor extends ServiceExecutor
{
	public JoTest0709BExecutor() {
		serviceObject = new JoTest0709B();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

