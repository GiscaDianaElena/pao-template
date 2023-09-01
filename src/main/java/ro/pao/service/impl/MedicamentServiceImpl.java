package ro.pao.service.impl;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
// import ro.pao.application.csv.CsvReader;
// import ro.pao.application.csv.CsvWriter;
import ro.pao.model.Medicament;
import ro.pao.repository.MedicamentRepository;
import ro.pao.service.MedicamentService;

import java.util.*;

/**
 * Aici implementam metodele din interfata serviciului definit.
 */
@RequiredArgsConstructor
@Getter
public class MedicamentServiceImpl implements MedicamentService {

    private final MedicamentRepository medicamentRepository;

    @Override
    public Optional<Medicament> getById(UUID id) {
        return medicamentRepository.getObjectById(id);
    }

    @Override
    public Optional<Medicament> getByNume(Medicament someFieldFromMedicament) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Medicament>> getByPret() {
        Optional<List<Medicament>> byPret = getByPret(null);
        Optional<List<Medicament>> byPret1 = byPret;
        return byPret1;
    }

    /*
    @Override
    public Optional<List<Medicament>> getByPret(Double pret) {
        return Optional.empty();
    }
     */

    @Override
    public Optional<Medicament> getByName(Medicament someFieldFromMedicament) {
        return Optional.empty();
    }

    @Override
    public Optional<List<Medicament>> getByPret(Double pret) {

        //return Optional.empty();
        return medicamentRepository.getObjectByPret(pret);

    }

    @Override
    public List<Medicament> getAllFromList() {
        return medicamentRepository.getAll();
    }

    @Override
    public List<Medicament> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Medicament> MedicamentList) {
        medicamentRepository.addAllFromGivenList(MedicamentList);
    }

    @Override
    public void addOnlyOne(Medicament Medicament) {
        medicamentRepository.addNewObject(Medicament);
    }

    @Override
    public void removeElementById(UUID id) {
        medicamentRepository.deleteObjectById(id);
    }

    @Override
    public void modificaElementById(UUID id, Medicament newElement) {
        medicamentRepository.updateObjectById(id, newElement);
    }


    /*
    private void readFromCsv(List<Medicament> MedicamentList) throws Exception {
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

    private void writeToCsv(List<Medicament> MedicamentList) throws Exception {
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