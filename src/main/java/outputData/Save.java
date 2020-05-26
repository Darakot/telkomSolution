package outputData;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Интерфейс описывает сохранение изображений в нужном формате
 */

public interface Save {
    /**
     * @param images - список изображений
     * @param path - путь по которому будет создана папка, в которой будут храниться изображения
     * @param nameJpg - имя с которым будут сохраняться изображения
     * @param page - номер страницы(Конечно имя файла будет иметь вид Имя + номер страницы + формат файла)
     * @throws IOException
     */
    void save(BufferedImage images, Path path, String nameJpg, int page) throws IOException;
}
