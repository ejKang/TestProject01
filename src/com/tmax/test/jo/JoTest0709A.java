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
* ȭ�ϸ� : JoTest0709A.class
* ������α׷� : JoTest0709A
* ���� : JoTest0709A 
**************************************************************************************************************/
public class JoTest0709A extends JobServiceObjectWrapper
{
	
		@Override
		public JobInfo getJobInfo(DataObject inputDataObject) {
			
			 JobInfo jobInfo = new JobInfo();
			 jobInfo.setJobId("JoTest0709A");
			 jobInfo.setJobName("JoTest0709A");
			    
			 jobInfo.setStepInfos(new StepInfo[]{});
			
			 return jobInfo;
		}
		
		
}

