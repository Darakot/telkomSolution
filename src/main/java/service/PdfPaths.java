package service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Класс для получения путей файлов
 * Повторное сканирование избегается путем сравнение коллекций, но возможно надо было делать БД в памяти и писать
 * файлики туда.
 */
public class PdfPaths implements PathFiles {
    private List<Path> pathsFiles;

    public PdfPaths() {
        this.pathsFiles = new ArrayList<>();
    }

    /**
     * Получаем список путей тольк PDF фалйлов
     * @param catalog - Каталог для сканирования
     * @return - Список путей pdf файлов
     * @throws IOException
     */
    @Override
    public List<Path> getPaths(String catalog) throws IOException {
        List<Path> paths = Files.walk(Paths.get(catalog))
                .filter(Files::isRegularFile)
                .filter(f -> f.getFileName().toString().contains(".pdf"))
                .collect(Collectors.toList());
        if (!pathsFiles.isEmpty()) {
            paths.removeAll(pathsFiles);
        }
        pathsFiles.addAll(paths);
        return paths;
    }
}
