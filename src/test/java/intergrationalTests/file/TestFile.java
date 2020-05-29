package intergrationalTests.file;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;

/**
 * Интерфейс для создание тестовых файлов
 */
public interface TestFile {
    void createFile() throws DocumentException, FileNotFoundException;
}
