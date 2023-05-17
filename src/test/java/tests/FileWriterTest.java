package tests;

import org.testng.annotations.Test;
import utils.FileManagerUtil;
import utils.FileWriterUtil;
import java.io.IOException;


public class FileWriterTest {

    @Test
    public void testWriteDataToFile() throws IOException {
        FileWriterUtil.writeDataToFile(FileManagerUtil.getValue("settings.json", "fileOutput"));
    }
}
