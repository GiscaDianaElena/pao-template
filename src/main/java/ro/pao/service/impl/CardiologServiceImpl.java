package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
// import ro.pao.application.csv.CsvReader;
// import ro.pao.application.csv.CsvWriter;
import ro.pao.model.Cardiolog;
import ro.pao.model.Medici;
import ro.pao.repository.CardiologRepository;
import ro.pao.repository.MediciRepository;
import ro.pao.service.CardiologService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@RequiredArgsConstructor
@Getter
public class CardiologServiceImpl implements CardiologService {
    private final CardiologRepository cardiologRepository;
    private static List<Cardiolog> cardiologList = new ArrayList<>();

    @Override
    public Optional<Cardiolog> getById(UUID id) {
        return cardiologRepository.getObjectById(id);
    }

    @Override
    public Optional<Cardiolog> getBySomeFieldOfClass(Object someFieldFromCardiolog) {
        return Optional.empty();
    }

    @Override
    public List<Cardiolog> getAllFromList() {
        return cardiologRepository.getAll();
    }

    @Override
    public List<Cardiolog> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Cardiolog> CardiologList) {
        cardiologRepository.addAllFromGivenList(CardiologList);
    }

    @Override
    public void addOnlyOne(Cardiolog Cardiolog) {
        cardiologRepository.addNewObject(Cardiolog);
    }

    @Override
    public void removeElementById(UUID id) {
        cardiologRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Cardiolog newElement) {
        cardiologRepository.updateObjectById(id, newElement);
    }


    /*
    private void readFromCsv(List<Cardiolog> CardiologList) throws Exception {
        try {
            CsvReader csvReader = CsvReader.getInstance();

            // Read all lines at once
            List<String[]> allLines = csvReader.executeAllLines();
            for (String[] line : allLines) {
                System.out.println(Arrays.toString(line));
            }

            // Read line by line
            List<String[]> lineByLine = csvReader.executeLineByLine();
            for (String[] line : lineByLine) {
                System.out.println(Arrays.toString(line));
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
     */

    /*
    private void writeToCsv(List<Cardiolog> CardiologList) throws Exception {
        // Suppose you have a list of String[] arrays representing rows in a CSV file, like this:
        List<String[]> lines = new ArrayList<>();
        lines.add(new String[] {"id", "name", "age"});
        lines.add(new String[] {"1", "John Doe", "35"});
        lines.add(new String[] {"2", "Jane Doe", "30"});
        lines.add(new String[] {"3", "Bob Smith", "45"});

        // To write this data to a CSV file using CsvWriter, you can write the following code:

        try {
            CsvWriter csvWriter = CsvWriter.getInstance();

            // Write line by line
            Path lineByLinePath = Paths.get("line_by_line.csv");

            //String lineByLineContentsPathDefined = csvWriter.executeLineByLine(lines);
            String lineByLineContents = csvWriter.writeLineByLine(lines, lineByLinePath);
            System.out.println("Contents of line_by_line.csv:");
            System.out.println(lineByLineContents);



            // Write all lines at once
            Path allLinesPath = Paths.get("all_lines.csv");
            //String allLinesContents = csvWriter.executeAllLines(lines);
            String allLinesContents = csvWriter.writeAllLines(lines, allLinesPath);
            System.out.println("Contents of all_lines.csv:");
            System.out.println(allLinesContents);

        } catch (Exception e) {
            e.printStackTrace();
        }

     */

    }