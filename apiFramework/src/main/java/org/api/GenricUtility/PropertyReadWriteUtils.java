package org.api.GenricUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyReadWriteUtils {

    private Properties properties;

    public PropertyReadWriteUtils(String environment)
    {
        try
        {
            FileInputStream fis=new FileInputStream(System.getProperty("user.dir")+"/src/test/resources/Properties/"+environment+".Properties");
            properties=new Properties();
            properties.load(fis);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }

    public String getPropertyName(String fecthPropertyName)
    {
        return properties.getProperty(fecthPropertyName);
    }

    public void setPropertName(String propertName,String Value)
    {
        properties.setProperty(propertName,Value);
    }
}
