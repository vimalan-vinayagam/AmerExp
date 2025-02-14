package Utils.ApiHelper;

import Utils.CustomException;

import java.io.File;

public class Payload extends Headers{

    public static String payload(String filePath){
        try {
            return returnJsonToString(filePath);
        }catch (Exception e){
            throw new CustomException("Invalif Payload : "+e.getMessage());
        }
    }
    public static String returnJsonToString(String filePath){
        try {
            return objectMapper.writeValueAsString(objectMapper.readTree(new File(filePath)));
        }catch (Exception e){
            throw  new CustomException("Invalid File Path or Payload : "+e.getMessage());
        }
    }

}
