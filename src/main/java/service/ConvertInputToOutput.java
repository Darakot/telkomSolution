package service;

import java.io.IOException;

/**
 * ИНтерфейс описывает работу с файлами
 */
public interface ConvertInputToOutput {
    /**
     * Конвертирует один формат файла в другой
     * @throws IOException
     */
    void convert() throws IOException, InterruptedException;
}
