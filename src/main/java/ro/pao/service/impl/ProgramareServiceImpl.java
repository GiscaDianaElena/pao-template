package ro.pao.service.impl;
import java.util.logging.Logger;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
// import ro.pao.application.csv.CsvReader;
// import ro.pao.application.csv.CsvWriter;
import ro.pao.model.Programare;
import ro.pao.model.Medici;
import ro.pao.repository.ProgramareRepository;
import ro.pao.repository.MediciRepository;
import ro.pao.service.ProgramareService;

import javax.xml.crypto.Data;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.sql.SQLException;
import java.util.*;


/**
 * Aici implementam metodele din interfata serviciului definit.
 */

@Getter
public class ProgramareServiceImpl implements ProgramareService {

    private static final Logger logger = Logger.getGlobal();

    private final ProgramareRepository programareRepository;
    private static List<Programare> programareList = new ArrayList<>();

    public ProgramareServiceImpl(ProgramareRepository programareRepository) {
        this.programareRepository = programareRepository;
    }


    @Override
    public Optional<Programare> getById(UUID id) throws SQLException {

            Optional<Programare> programare = Optional.empty();
          programare = programareRepository.getProgramareByIdProgramare(id);


  //      try {

  //          appointment = appointmentRepository.getAppointmentById(id);

 //       } catch (CustomFileNotFoundException e) {
//
//            logger.log(Level.WARNING, e.getMessage());
//
//        } catch (Exception e) {
//
//            logger.log(Level.SEVERE, e.getMessage());
//
//        }

        return ProgramareRepository.getProgramareById(id);
    }

    @Override
    public Optional<List<Programare>> getByData(String date) {

        //return Optional.empty();
        return programareRepository.getObjectByData(date);

    }

    @Override
    public Optional<List<Programare>> getByMedici(UUID id) {

        //return Optional.empty();
        return programareRepository.getObjectByMedici(id);

    }

    @Override
    public List<Programare> getAllFromList() {
        return programareRepository.getAll();
    }

    @Override
    public List<Programare> getAllWithCondition() {
        return null;
    }

    @Override
    public void addAllFromGivenList(List<Programare> ProgramareList) {
        programareRepository.addAllFromGivenList(ProgramareList);
    }

    @Override
    public void addOnlyOne(Programare Programare) {
        programareRepository.addNewProgramare(Programare);
    }

    @Override
    public void removeElementById(UUID id) {
        programareRepository.deleteProgramareById(id);
    }

    @Override
    public void modificaElementById(UUID id, Programare newElement) {
        programareRepository.updateProgramareById(id, newElement);
    }

    /*
    private void readFromCsv(List<Programare> ProgramareList) throws Exception {
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
    private void writeToCsv(List<Programare> ProgramareList) throws Exception {
        // Suppose you have a list of String[] arrays representing rows in a CSV file, like this:
        List<String[]> lines = new ArrayList<>();
        lines.add(new String[] {"id", "nume", "varsta"});
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