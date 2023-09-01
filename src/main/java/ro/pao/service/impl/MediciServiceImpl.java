package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
// import ro.pao.application.csv.CsvReader;
// import ro.pao.application.csv.CsvWriter;
import ro.pao.model.Medici;
import ro.pao.repository.MediciRepository;
import ro.pao.service.MediciService;

import java.util.*;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@RequiredArgsConstructor
@Getter
public class MediciServiceImpl implements MediciService {

    private final MediciRepository mediciRepository;

    @Override
    public Optional<Medici> getById(String id) {
        return mediciRepository.getMediciById(id);
    }

    @Override
    public Optional<List<Medici>> getByNume(String nume) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Medici>> getByName(String name) {
        return mediciRepository.getObjectByName(name);
    }

    @Override
    public Optional<Medici> getBySomeFieldOfClass(Medici someFieldFromMedici) {
        return Optional.empty();
    }

    @Override
    public List<Medici> getAllFromList() {
        return mediciRepository.getAll();
    }

    @Override
    public List<Medici> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Medici> MediciList) {
        mediciRepository.addAllFromGivenList(MediciList);
    }

    @Override
    public void addOnlyOne(Medici Medici) {
        mediciRepository.addNewMedici(Medici);
    }

    @Override
    public void removeElementById(String id) {
        mediciRepository.deleteMediciById(id);
    }

    @Override
    public void modificaElementById(String id, Medici newElement) {
        mediciRepository.updateMediciById(id, newElement);
    }

    /*
    private void readFromCsv(List<Medici> MediciList) throws Exception {
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
    private void writeToCsv(List<Medici> MediciList) throws Exception {
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