package Utils.ApiHelper;


import Utils.CustomException;
import Utils.PropertyReader;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

import java.util.Map;

public class RestUtils {

    public static Response sendRequest(String method, String endPoints, Map<String,String> headers, String payload){
        RequestSpecification request = RestAssured.given().baseUri(PropertyReader.getProperty("baseurl"));
        if (headers!=null){
            request.headers(headers);
        }
        if (payload!=null){
            request.body(payload);
        }
        switch (method.toUpperCase()){
            case "POST":
                return request
                        .when()
                        .post(endPoints);
            case "PUT":
                return request
                        .when()
                        .put(endPoints);
            case "GET":
                return request
                        .when()
                        .get(endPoints);
            case "DELETE":
                return request
                        .when()
                        .delete(endPoints);
            default:
                throw  new CustomException("Invalid HTTPS Request : " +method);

        }
    }
}
