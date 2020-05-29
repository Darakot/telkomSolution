package intergrationalTests.file;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Класс для создание файла нужного формата
 */
public class TestPdf implements TestFile {
    String filename;

    public TestPdf(String filename) {
        this.filename = filename;
    }

    //Создание файла
    @Override
    public void createFile() throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(filename));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        for(int i = 0;i<2;i++) {
            Chunk chunk = new Chunk("Testing" + i, font);
            document.add(chunk);
            document.newPage();
        }
        document.close();
    }
}
