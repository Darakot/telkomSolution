import properties.Directory;
import service.ConvertInputToOutput;
import service.ConvertPdfToJpg;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        ConvertInputToOutput convertPdfToJpg = new ConvertPdfToJpg(Directory.getPath());

        while (true) {
            long start = System.currentTimeMillis();

            convertPdfToJpg.convert();

            long ms = System.currentTimeMillis() - start;

            Thread.sleep(300000 - ms);
        }
    }
}
