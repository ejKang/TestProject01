package com.tmax.test.biz;

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

import com.tmax.test.data.Do1;
import com.tmax.proobject.batch.context.JobContext;
import java.util.Map;

/**************************************************************************************************************
* ȭ�ϸ� : Jo1.class
* ������α׷� : Jo1
* ���� : Jo1 
**************************************************************************************************************/
public class Jo1 extends JobServiceObjectWrapper
{
	
		@Override
		public JobInfo getJobInfo(DataObject inputDataObject) {
			
			 JobInfo jobInfo = new JobInfo();
			 jobInfo.setJobId("Jo1");
			 jobInfo.setJobName("Jo1");
			    
				
			
			 jobInfo.setStepInfos(new StepInfo[]{});
			
			 return jobInfo;
		}
		
		@Override
		protected void stepCallFlow(JobInfo jobInfo, JobContext jobContext, Map<String,String> jobParamter){
				if(true){
				}
			}
		
		
}

