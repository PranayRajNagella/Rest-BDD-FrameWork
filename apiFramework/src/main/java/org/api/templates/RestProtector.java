package org.api.templates;

import org.api.RestUtility.RestBase;
import org.api.RestUtility.RestValidator;

public class RestProtector {


    ThreadLocal<RestBase> restBaseThreadLocal=new ThreadLocal<>();
    ThreadLocal<RestValidator> restValidatorThreadLocal=new ThreadLocal<RestValidator>();
    private static RestProtector restProtector;
    private RestProtector()
    {

    }

    public static  RestProtector getRestProtector()
    {
        if(restProtector==null)
        {
            restProtector=new RestProtector();
        }
        return restProtector;
    }

    public synchronized void setRestBase(RestBase base)
    {
        restBaseThreadLocal.set(base);
    }

    public RestBase getRestBase()
    {
        return  restBaseThreadLocal.get();
    }


    public synchronized void setRestValidator(RestValidator restValidator)
    {
        restValidatorThreadLocal.set(restValidator);
    }

    public RestValidator getRestValidator()
    {
        return  restValidatorThreadLocal.get();
    }



}
