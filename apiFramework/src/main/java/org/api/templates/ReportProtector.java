package org.api.templates;

import com.aventstack.extentreports.ExtentTest;
import org.api.RestUtility.RestBase;
import org.api.RestUtility.RestValidator;

public class ReportProtector {

    ThreadLocal<ExtentTest> restBaseThreadLocal=new ThreadLocal<ExtentTest>();
    private static ReportProtector restProtector;
    private ReportProtector()
    {

    }

    public static  ReportProtector getRestProtector()
    {
        if(restProtector==null)
        {
            restProtector=new ReportProtector();
        }
        return restProtector;
    }

    public synchronized void setExtentReport(ExtentTest test)
    {
        restBaseThreadLocal.set(test);
    }
    public synchronized ExtentTest getExtentReport(ExtentTest test)
    {
       return restBaseThreadLocal.get();
    }



}
