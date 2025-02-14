package Utils.ApiHelper;

import Utils.CustomException;
import com.fasterxml.jackson.databind.ObjectMapper;
import io.restassured.mapper.ObjectMapperDeserializationContext;
import io.restassured.mapper.ObjectMapperSerializationContext;

import java.io.File;
import java.io.FileInputStream;
import java.util.Map;

public class Headers {

    protected static ObjectMapper objectMapper = new ObjectMapper();

    public static Map<String,String> headers(String filPath){
        try {
            return returnJsonToMap(filPath);
        } catch (Exception e) {
            throw new CustomException("Invalid headers : "+e.getMessage());
        }
    }

    public static Map<String,String> returnJsonToMap(String filePath){
        try {
            return objectMapper.readValue(new File(filePath),Map.class);
        } catch (Exception e) {
            throw new CustomException("Invalid File Path or data : "+e.getMessage());
        }
    }
}
