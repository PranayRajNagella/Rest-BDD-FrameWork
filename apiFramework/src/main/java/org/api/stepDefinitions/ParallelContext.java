package org.api.stepDefinitions;

import org.api.GenricUtility.PropertyReadWriteUtils;
import org.api.ReprotingUtility.ExtentReporter;

public class ParallelContext {

    private static PropertyReadWriteUtils propertyReadWriteUtils;

    public void baseSetup()
    {
        ExtentReporter.setUpExtentReport();
       if(propertyReadWriteUtils==null) {
           propertyReadWriteUtils = new PropertyReadWriteUtils(System.getProperty("user.dir") + "/src/test/resources/Properties/QA.Properties");
        }
    }

    public void endTest()
    {
        ExtentReporter.endExtentReport();
    }




}
