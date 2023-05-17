package utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.HashSet;
import java.util.Scanner;

public class FileWriterUtil {

    private static final Logger LOGGER = LogManager.getLogger();

    private FileWriterUtil(){}

    private static Integer countUniqueWordsInFile() {
        LOGGER.info("Counting number of the unique words in the file.");
        HashSet<String> uniqueWords = new HashSet<>();
        try {
            ClassLoader classloader = Thread.currentThread().getContextClassLoader();
            URL url = classloader.getResource(FileManagerUtil.getValue("settings.json", "fileInput"));
            assert url != null;
            File myObj = new File(url.toURI());
            Scanner myReader = new Scanner(myObj);
            while (myReader.hasNextLine()) {
                String data = myReader.nextLine();
                String[] words = data.trim().strip().split("\\s+");
                Collections.addAll(uniqueWords, words);
            }
            myReader.close();
            return uniqueWords.size();
        } catch (FileNotFoundException e) {
            LOGGER.error("Check if a file with this name exists.");
            e.printStackTrace();
        } catch (URISyntaxException e) {
            throw new RuntimeException(e);
        }
        return 0;
    }

    public static void writeDataToFile(String fileName) throws IOException {
        LOGGER.info("Writing data to the file.");
        Path path = Paths.get("src/main/resources/" + fileName);
        byte[] strToBytes = countUniqueWordsInFile().toString().getBytes();
        Files.write(path, strToBytes);
    }
}