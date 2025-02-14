package Utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class ConfigDataProvider {
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
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("Config.properties");) {
            if (input == null) {
                throw new CustomException("File not found in the directory : " + input);
            }
            properties.load(input);
        } catch (IOException e) {
            throw new CustomException("Failed to load file : "+e);
        }
        return properties;
    }

}
