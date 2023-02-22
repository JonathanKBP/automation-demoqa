package helpers;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class Settings  {
    private static final Properties properties = new Properties();
    
    static {
        try {
            FileInputStream input = new FileInputStream("src/test/java/helpers/config.properties");
            properties.load(input);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String getProperty(String chave) {
        return properties.getProperty(chave);
    }
}