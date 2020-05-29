package intergrationalTests;

import com.itextpdf.text.DocumentException;
import intergrationalTests.file.TestFile;
import intergrationalTests.file.TestPdf;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import service.ConvertInputToOutput;
import service.ConvertPdfToJpg;
import util.DeleteFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Тест для проверки работы программы
 * До загрузки класса создаем PDF файл с 2 страницами, после тестов удаляем файл и изображения которые были получены
 * путем конвертации.(файл создает в ресурсах, туда же сохраняются изображения)
 * testConvert - тестирует логику программы
 */
public class TestConvertPdfToJpg {

    //Создаем PDF
    @BeforeClass
    public static void createdFile() throws FileNotFoundException, DocumentException {
        TestFile pdf = new TestPdf("src\\test\\resources\\testFile.pdf");
        pdf.createFile();
    }

    @Test
    public void testConvert() throws IOException {
        String pathTestFile = "src\\test\\resources";
        File jpgFile1 = new File("src\\test\\resources\\testFile\\testFile_1.jpg");
        File jpgFile2 = new File("src\\test\\resources\\testFile\\testFile_2.jpg");

        ConvertInputToOutput convertPdfToJpg = new ConvertPdfToJpg(pathTestFile);
        convertPdfToJpg.convert();
        //Проверяем создались ли нужные нам файлы с нужными именами и форматом
        Assert.assertTrue(jpgFile1.exists());
        Assert.assertTrue(jpgFile2.exists());

    }

    //Удаляем все что создали и конвертировали
    @AfterClass
    public static void deleteFile(){
        DeleteFile.deleteFile("src\\test\\resources\\testFile.pdf");
        DeleteFile.deleteFile("src\\test\\resources\\testFile\\testFile_1.jpg");
        DeleteFile.deleteFile("src\\test\\resources\\testFile\\testFile_2.jpg");
        DeleteFile.deleteFile("src\\test\\resources\\testFile");
    }
}
