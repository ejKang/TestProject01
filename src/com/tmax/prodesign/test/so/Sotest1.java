package com.tmax.prodesign.test.so;


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
import tmax.test.dto.DDD;

/**************************************************************************************************************
* ȭ�ϸ� : Sotest1.class
* ������α׷� : Sotest1
* ���� : Sotest1 
**************************************************************************************************************/
@ServiceObject
public class Sotest1 implements com.tmax.proobject.model.service.ServiceObject<tmax.test.dto.DDD, tmax.test.dto.DDD>
{
	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	    	
	
	    	
	/**
	* @�޼ҵ��  : service 
	* @����    : service
	* @�Է�      : ${arg.type} ${arg.name}
	* @���      : DDD
	* @ throws Exception java.lang.Throwable Throwable
	* @���� : 
	*/
	@Override
	public tmax.test.dto.DDD service(tmax.test.dto.DDD arg0) throws java.lang.Throwable
	{
	//[BEGIN_NODE_BLOCK, , service(DDD)]
	{
	
	//[BEGIN_NODE_BLOCK, 0, service(DDD)]
	{
	//버추얼 모듈
	 //[BEGIN_VIRTUAL_CODE_BLOCK, 0, service(DDD)]
	 {
		 return null;
	 }
	 //[END_VIRTUAL_CODE_BLOCK, 0, service(DDD)]
	
	}
	//[END_NODE_BLOCK, 0, service(DDD)]
	}
	//[END_NODE_BLOCK, , service(DDD)]
	}
	
}

