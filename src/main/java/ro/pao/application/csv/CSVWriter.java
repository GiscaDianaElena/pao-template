package ro.pao.application.csv;

/*
import com.opencsv.CSVReader;
import com.opencsv.CSVWriter;
import org.apache.commons.lang3.NotImplementedException;


import java.io.FileWriter;
import java.io.Reader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import static ro.pao.application.utils.Constants.CSV_PATH_READ;
import static ro.pao.application.utils.Constants.CSV_PATH_WRITE;

public class CsvWriter {

    private static CsvWriter INSTANCE;


    private CsvWriter() {
    }

    public static CsvWriter getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new CsvWriter();
        }

        return INSTANCE;
    }

    /*
    public String writeLineByLine(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toFile()))) {
            for (String[] line : lines) {
                writer.writeNext(line);
            }
        }
        // Read the file and return its contents
        return Files.readString(path);
    }


    public String writeAllLines(List<String[]> lines, Path path) throws Exception {
        try (CSVWriter writer = new CSVWriter(new FileWriter(path.toString()))) {
            writer.writeAll(lines);
        }
        return Files.readString(path);
    }

    public String executeLineByLine(List<String[]> lines) throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_WRITE).toURI());

        return writeLineByLine(lines, path);
    }

    public String executeAllLines(List<String[]> lines) throws Exception {
        Path path = Paths.get(
                ClassLoader.getSystemResource(CSV_PATH_WRITE).toURI());

        return writeAllLines(lines, path);
    }
}
 */