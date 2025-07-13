package utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import static constants.constant.CONFIG_PROPERTIES_DIRECTORY;

public class utilityFecthProperty
{
    public static String fetchPropertyValue(String Key) throws IOException {
        FileInputStream file=new FileInputStream(CONFIG_PROPERTIES_DIRECTORY);
        Properties property=new Properties();
        property.load(file);
        return property.get(Key).toString();
    }
}
