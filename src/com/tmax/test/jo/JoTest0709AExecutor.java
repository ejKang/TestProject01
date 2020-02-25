package com.tmax.test.jo;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class JoTest0709AExecutor extends ServiceExecutor
{
	public JoTest0709AExecutor() {
		serviceObject = new JoTest0709A();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

