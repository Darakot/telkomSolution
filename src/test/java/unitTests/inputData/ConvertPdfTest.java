package unitTests.inputData;

import inputData.Convert;
import inputData.ConvertPdf;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mockito;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

/**
 * Простой unit тест на класс ConvertPdf
 */
public class ConvertPdfTest {

    Convert convertPdfMock = Mockito.mock(ConvertPdf.class);

    /**
     * Проверяем на то что объект не null и то что возвращает List<BufferedImage>
     * @throws IOException
     */
    @Test
    public void convert() throws IOException {
        List<BufferedImage> bufferedImage = new ArrayList<>();
        bufferedImage.add(new BufferedImage(300,600,1));
        bufferedImage.add(new BufferedImage(400,600,1));
        bufferedImage.add(new BufferedImage(500,600,1));

        when(convertPdfMock.convert("1.pdf")).thenReturn(bufferedImage);

        List<BufferedImage> convert = convertPdfMock.convert("1.pdf");

        Assert.assertEquals(convert,bufferedImage);
        Assert.assertNotNull(convert);
    }
}
