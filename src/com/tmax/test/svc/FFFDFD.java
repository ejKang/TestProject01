package com.tmax.test.svc;


import com.tmax.proobject.core.ServiceObject;
import com.tmax.proobject.model.business.BusinessObject;
import com.tmax.proobject.model.dataobject.DataObject;
import com.tmax.proobject.engine.servicemanager.*;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;
import com.tmax.proobject.model.dto.*;
import com.tmax.proobject.core.DataSource;
import javax.inject.Inject;
import com.tmax.proobject.engine.waitobject.WaitObject;
import java.math.BigDecimal;
import java.util.List;
import java.util.ArrayList;
import java.util.logging.Level;
import java.io.File;
import com.tmax.proobject.model.transaction.TransactionType;
import com.tmax.proobject.service.RCallReturn;
import com.tmax.proobject.dataobject.util.DataDefinitionExecutor;
import com.tmax.test.data.Do1;

/**************************************************************************************************************
* ȭ�ϸ� : FFFDFD.class
* ������α׷� : FFFDFD
* ���� : sdf 
**************************************************************************************************************/
@ServiceObject
public class FFFDFD implements com.tmax.proobject.model.service.ServiceObject<com.tmax.test.data.Do1, com.tmax.test.data.Do1>
{
	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	    	
	
	    	
	/**
	* @�޼ҵ��  : service 
	* @����    : service
	* @�Է�      : ${arg.type} ${arg.name}
	* @���      : Do1
	* @ throws Exception java.lang.Throwable Throwable
	* @���� : 
	*/
	@Override
	public com.tmax.test.data.Do1 service(com.tmax.test.data.Do1 arg0) throws java.lang.Throwable
	{
	//[BEGIN_NODE_BLOCK, , service(Do1)]
	{
	
	//[BEGIN_NODE_BLOCK, 0, service(Do1)]
	{
	//버추얼 모듈
	 //[BEGIN_VIRTUAL_CODE_BLOCK, 0, service(Do1)]
	 {
		 return null;
	 }
	 //[END_VIRTUAL_CODE_BLOCK, 0, service(Do1)]
	
	}
	//[END_NODE_BLOCK, 0, service(Do1)]
	}
	//[END_NODE_BLOCK, , service(Do1)]
	}
	
}

