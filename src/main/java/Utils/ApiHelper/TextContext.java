package Utils.ApiHelper;

import Utils.CustomException;

import java.util.HashMap;
import java.util.Map;

public class TextContext {
    private static TextContext instance;
    private final Map<String, Object> dataStore;

    private TextContext(){
        dataStore = new HashMap<>();
    }
    public static TextContext getInstance(){
        if (instance==null){
            instance = new TextContext();
        }
        return instance;
    }

    public void setValue(String value, Object key){
        dataStore.put(value,key);
    }

    public static String getStoredValue(String key){
        Object value = getInstance().dataStore.get(key);
        if (value==null){
            throw new CustomException("Stored key value is invalid or not used or wrong value : "+value);
        }
        return value.toString();
    }
}
