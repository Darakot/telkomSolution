package service;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class PdfPaths implements PathFiles {

    /**
     * Получаем список путей тольк PDF фалйлов
     * @param catalog - Каталог для сканирования
     * @return - Список путей pdf файлов
     * @throws IOException
     */
    @Override
    public List<Path> getPaths(String catalog) throws IOException {
        return java.nio.file.Files.walk(Paths.get(catalog))
                .filter(java.nio.file.Files::isRegularFile)
                .filter(f -> f.getFileName().toString().contains(".pdf"))
                .collect(Collectors.toList());
    }
}
