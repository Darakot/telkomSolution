package intergrationalTests.file;

import com.itextpdf.text.*;
import com.itextpdf.text.pdf.PdfWriter;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;

/**
 * Класс для создание и удаление файла нужного формата
 */
public class TestPdf implements TestFile {
    //Создание файла
    @Override
    public void createFile(String nameFile) throws DocumentException, FileNotFoundException {
        Document document = new Document();
        PdfWriter.getInstance(document, new FileOutputStream(nameFile));

        document.open();
        Font font = FontFactory.getFont(FontFactory.COURIER, 16, BaseColor.BLACK);
        for(int i = 0;i<2;i++) {
            Chunk chunk = new Chunk("Testing" + i, font);
            document.add(chunk);
            document.newPage();
        }
        document.close();
    }
    //Удаление файла
    @Override
    public void deleteFile(String nameFile) {
        File file = new File(nameFile);
        file.delete();
    }
}
