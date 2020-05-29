package intergrationalTests.file;

import com.itextpdf.text.DocumentException;

import java.io.FileNotFoundException;

/**
 * BИнтерфейс для создание тестовых файлов
 */
public interface TestFile {
    void createFile(String nameFile) throws DocumentException, FileNotFoundException;
    void deleteFile(String nameFile);
}
