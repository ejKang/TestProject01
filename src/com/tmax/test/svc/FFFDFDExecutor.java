package com.tmax.test.svc;

import com.tmax.proobject.engine.service.executor.ServiceExecutor;

public class FFFDFDExecutor extends ServiceExecutor
{
	public FFFDFDExecutor() {
		serviceObject = new FFFDFD();
	}
	
	public Object execute(Object serviceInput, String serviceExecutionMethod) throws Throwable {
		return serviceObject.service(serviceInput);
	}
	
	public String getRendezvousMethodName(String service){
		return null;
	}
	
}

