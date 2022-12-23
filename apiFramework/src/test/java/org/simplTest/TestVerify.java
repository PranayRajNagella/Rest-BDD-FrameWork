package org.simplTest;

import io.restassured.response.Response;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.api.RestUtility.RestBase;
import org.api.RestUtility.RestValidator;
import org.api.customExceptions.StatusCodeMisMatchExceptions;
import org.api.templates.RestProtector;

import java.util.LinkedHashMap;
import java.util.Map;

public class TestVerify {

    private static RestBase restBase;

    private static final Logger logger = LogManager.getLogger(TestVerify.class);
    private static Map <String,Object> Headers=new LinkedHashMap<>();
    private static Map<String,Object> queryParams=new LinkedHashMap<>();
    private static Map<String,Object> path=new LinkedHashMap<>();
    public static void main(String[] args) throws StatusCodeMisMatchExceptions {
        RestProtector.getRestProtector().setRestBase(new RestBase());
        restBase=RestProtector.getRestProtector().getRestBase();
        Response response =restBase.GET_API_CALL(Headers,queryParams,path,"https://catfact.ninja","/fact");
        RestProtector.getRestProtector().setRestValidator(new RestValidator());
        RestProtector.getRestProtector().getRestValidator().validateStatusCode(response,200);
        logger.debug("Hello Here");
    }
}