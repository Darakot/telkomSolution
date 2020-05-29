package unitTests.util;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.powermock.api.mockito.PowerMockito;
import org.powermock.core.classloader.annotations.PrepareForTest;
import org.powermock.modules.junit4.PowerMockRunner;
import util.DeleteFile;

import static org.mockito.Mockito.when;

/**
 * Простой unit тест на класс DeleteFile
 */
@RunWith(PowerMockRunner.class)
@PrepareForTest({DeleteFile.class})
public class DeleteFileTest {


    /**
     * Проверяет удаления файла
     */
    @Test
    public void deleteFile() {
        PowerMockito.mockStatic(DeleteFile.class);
        when(DeleteFile.deleteFile("C:\\1.pdf")).thenReturn(true);
        Assert.assertTrue(DeleteFile.deleteFile("C:\\1.pdf"));
    }



}
