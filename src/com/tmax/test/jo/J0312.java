package com.tmax.test.jo;

import com.tmax.proobject.batch.info.BatchInfo;
import com.tmax.proobject.batch.info.ETLTaskInfo;
import com.tmax.proobject.batch.info.OnlineTaskInfo;
import com.tmax.proobject.batch.info.JobInfo;
import com.tmax.proobject.batch.info.PartitionerInfo;
import com.tmax.proobject.batch.info.StepInfo;
import com.tmax.proobject.batch.info.TaskInfo;
import com.tmax.proobject.batch.info.NormalTaskInfo;
import com.tmax.proobject.batch.service.JobServiceObjectWrapper;
import com.tmax.proobject.model.dataobject.DataObject;


/**************************************************************************************************************
* ȭ�ϸ� : J0312.class
* ������α׷� : J0312
* ���� : J0312 
**************************************************************************************************************/
public class J0312 extends JobServiceObjectWrapper
{
	
		@Override
		public JobInfo getJobInfo(DataObject inputDataObject) {
			
			 JobInfo jobInfo = new JobInfo();
			 jobInfo.setJobId("J0312");
			 jobInfo.setJobName("J0312");
			    
			 jobInfo.setStepInfos(new StepInfo[]{});
			
			 return jobInfo;
		}
		
		
}

