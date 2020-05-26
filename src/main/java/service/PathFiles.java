package service;

import java.io.IOException;
import java.nio.file.Path;
import java.util.List;

/**
 * Интерфейс описывает работу с путям файлов
 */
public interface PathFiles {
    /**
     * Получаем список путей нужного формата фалйлов
     * @param catalog - Каталог для сканирования
     * @return - Список путей
     * @throws IOException
     */
    List<Path> getPaths(String catalog) throws IOException;
}
