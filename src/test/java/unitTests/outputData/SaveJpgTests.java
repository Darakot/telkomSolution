package unitTests.outputData;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import outputData.Save;
import outputData.SaveJpg;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.nio.file.Path;

import static org.mockito.Mockito.when;

/**
 * Простой unit тест на класс SaveJpg
 */
public class SaveJpgTests {

    Save saveJpg = Mockito.mock(SaveJpg.class);

    @Mock
    BufferedImage images;
    @Mock
    Path path;

    /**
     * Проверяем, что класс сохранит нужный нам файл с изображением
     * @throws IOException
     */
    @Test
    public void save() throws IOException {
        when(saveJpg.save(images,path,"File",1)).thenReturn(true);
        Assert.assertTrue(saveJpg.save(images,path,"File",1));
    }
}
