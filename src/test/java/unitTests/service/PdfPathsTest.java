package unitTests.service;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import service.PathFiles;
import service.PdfPaths;

import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Простой unit тест на класс PdfPaths
 */
public class PdfPathsTest {

    PathFiles pdfPaths = Mockito.mock(PdfPaths.class);
    @Mock
    Path path1;
    @Mock
    Path path2;

    /**
     * Проверяем что вернет нужные нам пути из каталога
     * @throws IOException
     */
    @Test
    public void getPaths() throws IOException {
        List<Path> paths = new ArrayList<>();
        paths.add(path1);
        paths.add(path2);

        when(pdfPaths.getPaths("C:\\PDF")).thenReturn(paths);
        List<Path> testsPaths = pdfPaths.getPaths("C:\\PDF");
        Assert.assertNotNull(testsPaths);
        Assert.assertEquals(testsPaths,paths);
    }
}
