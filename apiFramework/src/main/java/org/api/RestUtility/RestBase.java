package org.api.RestUtility;


import io.restassured.builder.RequestSpecBuilder;
import io.restassured.filter.Filter;
import io.restassured.filter.log.RequestLoggingFilter;
import io.restassured.filter.log.ResponseLoggingFilter;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import io.restassured.specification.ResponseSpecification;

import java.io.File;
import java.io.FileOutputStream;
import java.io.PrintStream;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import static io.restassured.RestAssured.*;

public class RestBase {

    private RequestSpecification requestSpec;
    private ResponseSpecification respSpec;
    private static PrintStream printer;

    public RequestSpecification getRequestSpecification(String BaseUri)
    {
        if(printer==null)
        {
            try
            {
                printer=new PrintStream(new File(System.getProperty("user.dir")+"/src/test/resources/logger.txt"));
            }
            catch (Exception e)
            {
                e.printStackTrace();
            }
        }
        List<Filter> filters=new LinkedList<>();
        filters.add(RequestLoggingFilter.logRequestTo(printer));
        filters.add(ResponseLoggingFilter.logResponseTo(printer));
        requestSpec=new RequestSpecBuilder().setBaseUri(BaseUri).addFilters(filters).setRelaxedHTTPSValidation().build();
        return given().spec(requestSpec);
    }

    public Response GET_API_CALL(Map<String,Object> HeadersMap, Map<String,Object> pathParameters,Map<String,Object> queryParameters, String basePath, String endiPoint)
    {
       return this.getRequestSpecification(basePath).when().headers(HeadersMap).pathParams(pathParameters).queryParams(queryParameters).get(endiPoint).then().extract().response();
    }

    public Response POST_API_CALL(Map<String,Object> HeadersMap, Map<String,Object> pathParameters, String basePath, String endiPoint,Object jsonBody)
    {
        return this.getRequestSpecification(basePath).when().headers(HeadersMap).pathParams(pathParameters).body(jsonBody).post(endiPoint).then().extract().response();
    }

    public Response POST_API_CALL_FORM_PARAMS(Map<String,Object> HeadersMap, Map<String,Object> pathParameters, String basePath, String endiPoint,Map<String,Object> formParams)
    {
        return this.getRequestSpecification(basePath).when().headers(HeadersMap).pathParams(pathParameters).formParams(formParams).post(endiPoint).then().extract().response();
    }

    public Response PUT_API_CALL(Map<String,Object> HeadersMap, Map<String,Object> pathParameters, String basePath, String endiPoint,Object jsonBody)
    {
        return this.getRequestSpecification(basePath).when().headers(HeadersMap).pathParams(pathParameters).body(jsonBody).put(endiPoint).then().extract().response();
    }

    public Response PUT_API_CALL_FORM_PARAMS(Map<String,Object> HeadersMap, Map<String,Object> pathParameters, String basePath, String endiPoint,Map<String,Object> formParams)
    {
        return this.getRequestSpecification(basePath).when().headers(HeadersMap).pathParams(pathParameters).formParams(formParams).put(endiPoint).then().extract().response();
    }


    public Response DELETE_API_CALL(Map<String,Object> HeadersMap, Map<String,Object> pathParameters, String basePath, String endiPoint,Object jsonBody)
    {
        return this.getRequestSpecification(basePath).when().headers(HeadersMap).pathParams(pathParameters).body(jsonBody).delete(endiPoint).then().extract().response();
    }

    public Response DELETE_API_CALL_FORM_PARAMS(Map<String,Object> HeadersMap, Map<String,Object> pathParameters, String basePath, String endiPoint,Map<String,Object> formParams)
    {
        return this.getRequestSpecification(basePath).when().headers(HeadersMap).pathParams(pathParameters).formParams(formParams).delete(endiPoint).then().extract().response();
    }
}
