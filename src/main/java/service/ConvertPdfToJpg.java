package service;

import inputData.Convert;
import inputData.ConvertPdf;
import outputData.Save;
import outputData.SaveJpg;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

/**
 * Класс конвертирует PDF в Jpg
 */
public class ConvertPdfToJpg implements ConvertInputToOutput {
    PathFiles pathFiles = new PdfPaths();
    Convert convertPdf = new ConvertPdf();
    Save saveJpg = new SaveJpg();
    private String path;

    /**
     * При создании класса передаем ему каталог для сканирования
     * @param path - путь до каталога
     */
    public ConvertPdfToJpg(String path) {
        this.path = path;
    }


    /**
     * Метод конвертирует PDF в Jpg
     * @throws IOException
     */
    @Override
    public void convert() throws IOException {
        List<Path> paths = pathFiles.getPaths(path);

        for (Path path : paths) {
            List<BufferedImage> pagesImages = getConvert(path);
            Path homeDirectory = path.getParent();
            String nameFile = path.getFileName().toString().replace(".pdf", "");
            Path directoryImages = Files.createDirectories(Paths.get(homeDirectory + "\\" + nameFile));
            for (int count= 0;count < pagesImages.size(); count++ ) {
                getSave(pagesImages.get(count), directoryImages, nameFile, count+1);
            }
        }

    }

    /**
     * Конвертирует файл в список изображений, но не сохраняет их
     * @param path - путь до файла
     * @return - список изображений
     * @throws IOException
     */
    private List<BufferedImage> getConvert(Path path) throws IOException {
        return convertPdf.convert(path.toString());
    }

    /**
     * Сохраняет передаенное изображение в формате Jpg
     * @param image - изображение
     * @param path - путь для сохранения изображения
     * @param nameFile - имя файла с которым будет сохранено изображение
     * @param count - номер страницы с которым будет сохранено изображение
     * @throws IOException
     */
    private void getSave(BufferedImage image, Path path, String nameFile, int count) throws IOException {
        saveJpg.save(image, path, nameFile, count++);
    }
}
