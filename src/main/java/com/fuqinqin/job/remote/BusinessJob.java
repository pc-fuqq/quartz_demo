package com.fuqinqin.job.remote;

import com.tj.platform.job.common.AbstarctMQJob;
import com.tj.platform.job.common.JobMessage;
import com.tj.platform.job.common.JobResult;
import com.tj.platform.job.common.spring.MQJob;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * Created by fuqinqin on 2018/10/31.
 */
@Component
@MQJob(systemCode = "quartz-demo", jobName = "testJob")
public class BusinessJob extends AbstarctMQJob {

    private static int count  = 0;

    @Override
    protected JobResult doBusiness(JobMessage jobMessage) {
        JobResult result = new JobResult();
        result.setJobRunId(jobMessage.getJobRunId());
        result.setMsg("生成排班成功");
        result.setCode(JobResult.SUCCESS);
        result.setResultTime(new Date());
        System.out.println(count++ +" - "+jobMessage.getJobRunId());
        return result;
    }
}
