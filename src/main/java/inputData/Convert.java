package inputData;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.List;

/**
 * Интерфейс описывает действия с входными файлами
 */
public interface Convert {
    /**
     * Метод конвертирует файл в список изображений
     * @param filename - Путь до файла
     * @return - список изображений
     * @throws IOException
     */
    List<BufferedImage> convert(String filename) throws IOException;
}
