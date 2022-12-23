package org.api.RestUtility;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.customExceptions.StatusCodeMisMatchExceptions;

public class RestValidator {


    private static final Logger logger = LogManager.getLogger(RestValidator.class);

    public boolean validateStatusCode(Response response,int ExtpectedStatusCode) throws StatusCodeMisMatchExceptions {
        boolean flag=false;
        logger.debug("the statusCode is "+response.statusCode()+" the expectedStatudCode "+ExtpectedStatusCode);
        if(response.statusCode()==ExtpectedStatusCode)
        {
            //flag=true;
           // throw new StatusCodeMisMatchExceptions("status code not valid");
        }
        return flag;
    }




}
