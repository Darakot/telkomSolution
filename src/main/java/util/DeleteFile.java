package util;

import lombok.NoArgsConstructor;
import lombok.extern.log4j.Log4j;

import java.io.File;

/**
 * Утильный класс для удаления файлов
 */
@Log4j
public class DeleteFile {
    /**
     * Удаляет файл или каталог
     * @param filename - имя файла или каталога для удаления
     * @return - 1 если удален или 0 если нет
     */
    public static boolean deleteFile(String filename) {
        File file = new File(filename);
        if(file.delete())  {
            log.info(String.format("Файл %s удален", filename));
            return true;
        }
        else {
            log.info(String.format("Файл %s уже удален или не существует", filename));
            return false;
        }
    }
}
