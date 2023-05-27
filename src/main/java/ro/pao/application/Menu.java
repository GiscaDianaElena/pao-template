package ro.pao.application;

import ro.pao.model.*;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
import ro.pao.application.csv.CSVWriter;
import ro.pao.model.Programare;
import ro.pao.model.entity.*;
import ro.pao.repository.impl.*;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.logging.Logger;
import java.util.stream.Collectors;

import static javax.swing.text.rtf.RTFAttributes.BooleanAttribute.True;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */



public class Menu {

    private static Menu Instance;

    private final ProgramareService programareService = new ProgramareServiceImpl(new ProgramareRepositoryImpl());

    private final FacturaService facturaService = new FacturaServiceImpl(new FacturaRepositoryImpl());

    private final FisaMedicalaService fisaMedicalaService = new FisaMedicalaServiceImpl(new FisaMedicalaRepositoryImpl());

    private final MediciService mediciService= new MediciServiceImpl(new MediciRepositoryImpl());

    private final PacientService pacientService = new PacientServiceImpl(new PacientRepositoryImpl());

    private final PromotiiService promotiiService = new PromotiiServiceImpl(
            new PromotiiRepositoryImpl());

    private final RezultatAnalizeService rezultatAnalizeService = new RezultatAnalizeServiceImpl(
            new RezultatAnalizeRepositoryImpl());

    private final ServiciiMedicaleService serviciiMedicaleService = new ServiciiMedicaleServiceImpl(
            new ServiciiMedicaleRepositoryImpl());

    private final TratamentService tratamentService = new TratamentServiceImpl(
            new TratamentRepositoryImpl());


    public static Menu getInstance() {
        return (Instance == null ? new Menu() : Instance);
    }

    public boolean intro() {
        Path lineByLinePath = Paths.get("./csv/medicamente.csv");

        String intro = """
                Intro example
                """;

        System.out.println(intro);

        System.out.println("Alege o optiune: ");
        System.out.println("1. Adauga un doctor");
        System.out.println("2. Vezi toata lista de doctori");
        System.out.println("3. Modifica numar de telefon");
        System.out.println("4. Sterge un doctor");
        System.out.println("5. Ordoneaza-i dupa anii de experienta");
        System.out.println("6. Sorteaza medicamentele in functie de stocul lor");
        System.out.println("7. Scrie in CSV lista de medicamente");

        Scanner keyboard = new Scanner(System.in);

        List<Pacient> PacientList = new ArrayList<>();

        PacientList.add(Pacient.builder())
                .nume("Georgescu")
                .prenume("Eduard")
                .dataNastere(03/06/1994)
                .gen("Masculin")
                .adresa("str. Macaului, nr. 765")
                .asigurareMedicala("Da")
                .build();


        PacientList.add(Pacient.builder())
                .nume("Paun")
                .prenume("Alexandra")
                .dataNastere(07/07/2000)
                .gen("Feminin")
                .adresa("str. Clopotului, nr. 10")
                .asigurareMedicala("Da")
                .build();

        PacientList.add(Pacient.builder())
                .nume("Niculescu")
                .prenume("Ionut")
                .dataNastere(09/12/2007)
                .gen("Masculin")
                .adresa("str. Progresului, nr. 500")
                .asigurareMedicala("Nu")
                .build();

    }

    /*
    private Optional<Object> MediciList;
    List<Medici> MediciList1 = MediciList.stream()
            .sorted(Comparator.comparingDouble(Medici::getExperienta))
            .collect(Collectors.toList());
    */



    public static void setInstance(Menu Instance) {
        Menu.Instance = Instance;
    }

    try{
        CsvWriter csvWriter = CsvWriter.getInstance();
        String lineByLineContents = csvWriter.writeLineByLine(lines, lineByLinePath);
        System.out.println("Contents of " + lineByLinePath + ":");
        System.out.println(lineByLineContents);
    } catch (Exception e) {
        e.printStackTrace();
    }

    public static void setInstance(Menu instance) {
        Instance = Instance;
    }

    public FacturaService getFacturaService() {
        return facturaService;
    }

    public FisaMedicalaService getFisaMedicalaService() {
        return fisaMedicalaService;
    }

    public MediciService getMediciService() {
        return mediciService;
    }

    public PacientService getPacientService() {
        return pacientService;
    }

    public PromotiiService getPromotiiService() {
        return promotiiService;
    }

    public RezultatAnalizeService getRezultatAnalizeService() {
        return rezultatAnalizeService;
    }

    public ServiciiMedicaleService getServiciiMedicaleService() {
        return serviciiMedicaleService;
    }

    public TratamentService getTratamentService() {
        return tratamentService;
    }

    public ProgramareService getProgramareService() {
        return programareService;
    }


    }
 */