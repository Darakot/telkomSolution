package util;

import lombok.extern.log4j.Log4j;

import java.io.File;

@Log4j
public class DeleteFile {
    public static void deleteFile(String filename) {
        File file = new File(filename);
        if(file.delete())  log.info(String.format("Файл %s удален", filename));
        else log.info(String.format("Файл %s уже удален или не существует", filename));
    }
}
