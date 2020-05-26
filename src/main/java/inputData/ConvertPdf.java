package inputData;

import org.apache.pdfbox.pdmodel.PDDocument;
import org.apache.pdfbox.rendering.ImageType;
import org.apache.pdfbox.rendering.PDFRenderer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * convert - конвертирует файл PDF в список изображений
 */
public class ConvertPdf implements Convert {
    /**
     * Метод конвертирует PDF в список изображений
     * @param filename - Путь до файла pdf
     * @return - список изображений
     * @throws IOException
     */
    @Override
    public List<BufferedImage> convert(String filename) throws IOException {
        PDDocument document = PDDocument.load(new File(filename));
        PDFRenderer pdfRenderer = new PDFRenderer(document);
        List<BufferedImage> images = new ArrayList<>();

        for (int page = 0; page < document.getNumberOfPages(); ++page) {
            BufferedImage bim = pdfRenderer.renderImageWithDPI(
                    page, 300, ImageType.RGB);
            images.add(bim);
        }

        document.close();

        return images;
    }
}
