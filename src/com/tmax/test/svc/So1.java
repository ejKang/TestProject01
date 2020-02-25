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
import com.tmax.test.data.Do1;

/**************************************************************************************************************
* ȭ�ϸ� : So1.class
* ������α׷� : So1
* ���� : dsdfsd dsfsdfdsfsd 
**************************************************************************************************************/
@ServiceObject
public class So1 implements com.tmax.proobject.model.service.ServiceObject<com.tmax.test.data.Do1, com.tmax.test.data.Do1>
{
	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public com.tmax.test.biz.Bo1 var1 = new com.tmax.test.biz.Bo1();
	@DataSource(name="newdev1")
	private com.tmax.test.dof.Dof1 var2 = null;
	    	
	
	    	
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
	//DECLARE ENTRY VARIABLES
	com.tmax.test.data.DDD2 doCall1 = new com.tmax.test.data.DDD2();
	
	//[BEGIN_NODE_BLOCK, 1, service(Do1)]
	{
	    //[BEGIN_PRE_ASSIGN_BLOCK, 1, service(Do1)]
	    
	    //[END_PRE_ASSIGN_BLOCK, 1, service(Do1)]
	    var1.bb();
	    //[BEGIN_POST_ASSIGN_BLOCK, 1, service(Do1)]
	    
	    //[END_POST_ASSIGN_BLOCK, 1, service(Do1)]
	}
	//[END_NODE_BLOCK, 1, service(Do1)]
	
	//[BEGIN_NODE_BLOCK, 2, service(Do1)]
	{
	//var2
	//[BEGIN_BEFORE_CODE, 2, service(Do1)]
	
	//[END_BEFORE_CODE, 2, service(Do1)]
	
	//[BEGIN_PRE_ASSIGN_BLOCK, 2, service(Do1)]
	//[END_PRE_ASSIGN_BLOCK, 2, service(Do1)]
	
	var2.setFullQuery(com.tmax.test.dof.Dof1.FULLQUERY.ABC);
	doCall1 = var2.get();
	
	
	//[BEGIN_POST_ASSIGN_BLOCK, 2, service(Do1)]
	//[END_POST_ASSIGN_BLOCK, 2, service(Do1)]
	
	//[BEGIN_AFTER_CODE, 2, service(Do1)]
	
	//[END_AFTER_CODE, 2, service(Do1)]
	}
	//[END_NODE_BLOCK, 2, service(Do1)]
	//[BEGIN_NODE_BLOCK, 4, service(Do1)]
	{
	//So0705A
	//[BEGIN_NODE_BLOCK, 4, service(Do1)]
	//[END_BEFORE_CODE, 4, service(Do1)]	
		com.tmax.test.data.DDD2 service_in = new com.tmax.test.data.DDD2();
		
		//[BEGIN_PRE_ASSIGN_BLOCK, 4, service(Do1)]
		
		//[END_PRE_ASSIGN_BLOCK, 4, service(Do1)]
		
		com.tmax.test.data.DDD2 service_out = new com.tmax.test.data.DDD2();
		service_out = (com.tmax.test.data.DDD2)ServiceManager.call("dbApp1.dbSg1.So0705A1", service_in, TransactionType.JOIN);
		
		//[BEGIN_POST_ASSIGN_BLOCK, 4, service(Do1)]
		
		//[END_POST_ASSIGN_BLOCK, 4, service(Do1)]
		
	//[END_NODE_BLOCK, 4, service(Do1)]
	
	}
	//[END_NODE_BLOCK, 4, service(Do1)]
	//[BEGIN_NODE_BLOCK, 0, service(Do1)]
	{
	//버추얼 모듈
	 //[BEGIN_VIRTUAL_CODE_BLOCK, 0, service(Do1)]
	 {
		 System.out.println("So1");
		 logger.info("So111!!");
		 return null;
	 }
	 //[END_VIRTUAL_CODE_BLOCK, 0, service(Do1)]
	
	}
	//[END_NODE_BLOCK, 0, service(Do1)]
	}
	//[END_NODE_BLOCK, , service(Do1)]
	}
	
}

