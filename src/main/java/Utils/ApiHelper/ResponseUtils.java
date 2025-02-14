package Utils.ApiHelper;

import Utils.CustomException;
import io.restassured.response.Response;

public class ResponseUtils {

    public static void setResponseAttribute(Response response, String getJsonPath, String setJsonPath){
        String value = response.jsonPath().getString(getJsonPath);
        if (value!=null){
            TextContext.getInstance().setValue(setJsonPath,value);
        }else {
            throw new CustomException("Invalid path or value return : "+getJsonPath);
        }
    }

    public static String getResponseAttribute(String key){
        return TextContext.getStoredValue(key);
    }
}
