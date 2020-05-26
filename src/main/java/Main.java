import properties.Directory;
import service.ConvertInputToOutput;
import service.ConvertPdfToJpg;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {
        ConvertInputToOutput convertPdfToJpg = new ConvertPdfToJpg(Directory.getPath());
        convertPdfToJpg.convert();
    }
}
