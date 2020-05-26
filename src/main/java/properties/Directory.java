package properties;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;


/**
 * Класс забирает путь из файла configConver.properties в котором указан нужный каталог
 */
public class Directory {
    private static Properties properties;

    static {
        ClassLoader classLoader = Directory.class.getClassLoader();
        File file = new File(classLoader.getResource("configConver.properties").getFile());
        properties = new Properties();

        try(FileInputStream fileProperties = new FileInputStream(file)) {
            properties.load(fileProperties);
        } catch (IOException ignored) {
        }
    }

    /**
     * Возвращает список путей к файлам
     * @return - список путей
     */
    public static String getPath() {
        return properties.getProperty("catalog");
    }
}
