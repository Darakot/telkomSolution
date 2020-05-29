package outputData;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;
import org.apache.pdfbox.tools.imageio.ImageIOUtil;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

/**
 * Сохраняет картинки в Jpg
 */
@Log4j
@NoArgsConstructor
public class SaveJpg implements Save {
    /**
     * @param images - список картинок
     * @param path - путь по которому будет создана папка, в которой будут храниться картинки
     * @param nameJpg - имя с которым будут сохраняться картинки
     * @param page - номер страницы(Конечно имя файла будет иметь вид Имя + номер страницы + формат файла)
     * @throws IOException
     */
    @Override
    public void save(BufferedImage images, Path path, String nameJpg, int page) throws IOException {
        ImageIOUtil.writeImage(images, String.format(path + "\\" + nameJpg + "_%d.jpg",page), 300);
        log.info(String.format("Файл сохранен с именем %s_%d в каталоге %s в формате jpg", nameJpg,page,path.toString()));
    }
}
