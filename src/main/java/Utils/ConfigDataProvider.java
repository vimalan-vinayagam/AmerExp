package Utils;


import Tools.BaseClass;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class ConfigDataProvider extends BaseClass {
    private static ConfigDataProvider config;
    private final Properties properties;

    private ConfigDataProvider(){
        properties = new Properties();

    }
    public static ConfigDataProvider getFileInstance() throws IOException {
        if (config == null){
            config = new ConfigDataProvider();
        }
        return config;
    }

    public Properties getPropertyFile() throws IOException {
        properties.load(new FileInputStream(System.getProperty("user.dir")+"/Data/Config.properties"));
        return properties;
    }

}
