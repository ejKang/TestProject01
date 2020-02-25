package com.tmax.test.biz;


import com.tmax.proobject.core.BizObject;
import com.tmax.proobject.model.business.BusinessObject;
import com.tmax.proobject.engine.servicemanager.*;
import com.tmax.proobject.logger.ProObjectLogger;
import com.tmax.proobject.logger.application.ServiceLogger;
import com.tmax.proobject.model.dto.*;
import java.math.BigDecimal;
import java.util.List;
import javax.inject.Inject;
import com.tmax.proobject.core.DataSource;
import com.tmax.proobject.engine.waitobject.WaitObject;
import java.util.ArrayList;
import java.util.logging.Level;
import java.io.File;
import com.tmax.proobject.model.transaction.TransactionType;
import com.tmax.proobject.dataobject.util.DataDefinitionExecutor;

/**************************************************************************************************************
* ȭ�ϸ� : Bo1.class
* ������α׷� : Bo1
* ���� : Bo1 
**************************************************************************************************************/
@BizObject(logicalName = "Bo1")
public class Bo1 implements BusinessObject
{
	
	private ProObjectLogger logger = ServiceLogger.getLogger();
	public com.tmax.test.data.Do1 var1 = new com.tmax.test.data.Do1();
	public com.app.biz.Do10 var2 = new com.app.biz.Do10();
	public com.app.biz.tttt var3 = new com.app.biz.tttt();
	    	
	
	    	
	/**
	* @�޼ҵ��  : bb 
	* @����    : bb
	* @�Է�      :  
	* @���      : ${returnType}
	* @ throws Exception Throwable Throwable
	* @���� : asdf
	*/
	public abstract void bb() throws Throwable
	;
	
}

