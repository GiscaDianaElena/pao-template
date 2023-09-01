package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
// import ro.pao.application.csv.CsvReader;
// import ro.pao.application.csv.CsvWriter;
import ro.pao.model.Tratament;
import ro.pao.model.Cardiolog;
import ro.pao.repository.TratamentRepository;
import ro.pao.service.TratamentService;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.*;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@RequiredArgsConstructor
@Getter
public class TratamentServiceImpl implements TratamentService {

    private final TratamentRepository tratamentRepository;
    private static List<Tratament> tratamentList = new ArrayList<>();

    @Override
    public Optional<Tratament> getById(UUID id) {
        return tratamentRepository.getObjectById(id);
    }

    @Override
    public Optional<Tratament> getBySomeFieldOfClass(Object someFieldFromTratament) {
        return Optional.empty();
    }

    @Override
    public List<Tratament> getAllFromList() {
        return tratamentRepository.getAll();
    }

    @Override
    public List<Tratament> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Tratament> TratamentList) {
        tratamentRepository.addAllFromGivenList(TratamentList);
    }

    @Override
    public void addOnlyOne(Tratament Tratament) {
        tratamentRepository.addNewObject(Tratament);
    }

    @Override
    public void removeElementById(UUID id) {
        tratamentRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Tratament newElement) {
        tratamentRepository.updateObjectById(id, newElement);
    }

    /*

    private void readFromCsv(List<Tratament> TratamentList) throws Exception {
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
    private void writeToCsv(List<Tratament> TratamentList) throws Exception {
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