package ro.pao.application;

import ro.pao.model.*;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;
// import ro.pao.application.csv.CSVWriter;
import ro.pao.model.Programare;
import ro.pao.model.Tratament;
import ro.pao.model.Medicament;
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

// import static javax.swing.text.rtf.RTFAttributes.BooleanAttribute.True;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */



public class Menu {

    private static Menu Instance;

    private final ProgramareService programareService = new ProgramareServiceImpl(new ProgramareRepositoryImpl());

    private final MediciService mediciService = new MediciServiceImpl(new MediciRepositoryImpl());

    private final PacientService pacientService = new PacientServiceImpl(new PacientRepositoryImpl());

    private final TratamentService tratamentService = new TratamentServiceImpl(
            new TratamentRepositoryImpl());

    private final CardiologService cardiologService = new CardiologServiceImpl(new CardiologRepositoryImpl());

    private final MedicamentService medicamentService = new MedicamentServiceImpl(new MedicamentRepositoryImpl());

    private final ORL_MEDICService orlMedicService = new ORL_MEDICServiceImpl(new ORL_MEDICRepositoryImpl());

    private final OftalmologService oftalmologService = new OftalmologServiceImpl(
            new OftalmologRepositoryImpl());

    private static final Logger logger = Logger.getGlobal();


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

        List<Persoana> persoanaList = new ArrayList<>();

        persoanaList.add(Pacient.builder()
                .idPersoana(("22"))
                .nume("Zotescu")
                .prenume("Alexandru")
                .email("zotescualexandru76@gmail.com")
                .CNP("6011217392288")
                .adresa("Str. Mihai Viteazul, nr. 65, Ploiesti")
                .boala("cancer")
                .status("moderat")
                .GrupaSange("B3")
                .AsigurareMedicala("Da")
                .numarTelefon("0786234123")
                .build());

        persoanaList.add(Pacient.builder()
                .idPersoana(("79"))
                .nume("Paraschiv")
                .prenume("Maria")
                .email("paraschivmaria88@gmail.com")
                .CNP("2880622682999")
                .adresa("Str. Stirbei Voda, nr. 5, Bucuresti")
                .boala("gastrita")
                .status("inceput")
                .GrupaSange("A1")
                .AsigurareMedicala("Nu")
                .numarTelefon("0792273741")
                .build());


        persoanaList.add(Pacient.builder()
                .idPersoana(("29"))
                .nume("Vasilache")
                .prenume("Emanuel")
                .email("vasilacheemanuel29@gmail.com")
                .CNP("1990703795833")
                .adresa("Str. Curcubeului, nr. 121, Iasi")
                .boala("cancer pulmonar")
                .status("critic")
                .GrupaSange("AB4")
                .AsigurareMedicala("Da")
                .numarTelefon("0755478119")
                .build());

        persoanaList.add(Cardiolog.builder()
                .idPersoana("19")
                .nume("Mihai")
                .prenume("Roxana")
                .email("mihai.roxana@gmail.com")
                .CNP("6011217387435")
                .adresa("Str. Pinului, nr.98")
                .experienta(12)
                // .data_angajare(DateFormat.getDateInstance().setCalendar(12-12-2001))
                .salariu(Double.valueOf(10000))
                .numarTelefon("0786234123")
                .build());

        persoanaList.add(ORL_MEDIC.builder()
                .idPersoana("1")
                .nume("Cerneut")
                .prenume("Sergiu")
                .email("cerneut.sergiu@gmail.com")
                .CNP("6534910429119")
                .adresa("Str. Trandafirului, nr.9")
                .experienta(10)
                //.hire_date(LocalDate.of(2013, 4, 23))
                .salariu(Double.valueOf(12000))
                .numarTelefon("0745128690")
                .build());

        persoanaList.add(Oftalmolog.builder()
                .idPersoana(("2"))
                .nume("Zanfir")
                .prenume("Radu")
                .email("zanfir.radu@gmail.com")
                .CNP("6011217309873")
                .adresa("Str. Zambilei, nr.6")
                .experienta(4)
                // .hire_date(LocalDate.of(2019, 2, 12))
                .salariu(Double.valueOf(12000))
                .numarTelefon("0798634123")
                .build());

        persoanaList.add(Cardiolog.builder()
                .idPersoana(("3"))
                .nume("Mircescu")
                .prenume("Vlad")
                .email("mircescu.vlad@gmail.com")
                .CNP("6011217987635")
                .adresa("Str. Pinului, nr.10")
                .experienta(25)
                //.hire_date(LocalDate.now())
                .salariu(Double.valueOf(109000))
                .numarTelefon("0799874123")
                .build());

        Medici medici = Medici.builder()
                .idPersoana(("4"))
                .nume("Brustur")
                .prenume("Mihaela")
                .email("brustur.mihaela@gmail.com")
                .CNP("6011217932115")
                .adresa("str. Rapsodiilor")
                .numarTelefon("0799878954")
                .data_angajare("1-12-2001")
                .experienta(Integer.valueOf(5))
                .salariu(Double.valueOf(4000))

                .programareList(List.of(new Programare(), new Programare()))
                .build();

        Medici medici1 = Medici.builder()
                .idPersoana(("5"))
                .nume("Grigorescu")
                .prenume("Sorana")
                .email("grigorescu.sorana@gmail.com")
                .CNP("6011217875390")
                .adresa("str. Zambilei")
                .numarTelefon("0790979823")
                .data_angajare("12-12-2001")
                .experienta(Integer.valueOf(1))
                .salariu(Double.valueOf(3000))
                .programareList(List.of(new Programare(), new Programare()))
                .build();

        Medici medici2 = Medici.builder()
                .idPersoana(("6"))
                .nume("Alexe")
                .prenume("Crina")
                .email("alexe.crina@gmail.com")
                .CNP("6011209000635")
                .adresa("str. Vaniliei")
                .numarTelefon("0799090043")
                .data_angajare("21-01-2001")
                .experienta(Integer.valueOf(3))
                .salariu(Double.valueOf(29000))
                .programareList(List.of(new Programare(), new Programare()))
                .build();

        Medici medici3 = Medici.builder()
                .idPersoana("7")
                .nume("Covrig")
                .prenume("Matei")
                .email("covrig.matei@gmail.com")
                .CNP("6011217980094")
                .adresa("str. Carpati")
                .numarTelefon("0799874123")
                .data_angajare("12-12-2001")
                .experienta(Integer.valueOf(3))
                .salariu(Double.valueOf(21000))
                .programareList(List.of(new Programare(), new Programare()))
                .build();

        Medici medici4 = Medici.builder()
                .idPersoana("23")
                .nume("Balan")
                .prenume("Victoria")
                .email("balan.victoria@gmail.com")
                .CNP("6011217097895")
                .adresa("Str. Iasomiei")
                .numarTelefon("0790935123")
                .data_angajare("12-12-2001")
                .experienta(Integer.valueOf(6))
                .salariu(Double.valueOf(17000))
                .programareList(List.of(new Programare(), new Programare()))
                .build();

        String Keyboard = keyboard.next();
        if ("0".equals(Keyboard)) {
            mediciService.addOnlyOne(medici);
            mediciService.addOnlyOne(medici1);
            mediciService.addOnlyOne(medici2);
            mediciService.addOnlyOne(medici3);
            mediciService.addOnlyOne(medici4);
        }

        if ("1".equals(Keyboard)) {

            Scanner id_doc1 = new Scanner(System.in);
            System.out.println("Introdu id-ul doctorului:");
            String id_doc = id_doc1.nextLine();

            Scanner name1 = new Scanner(System.in);
            System.out.println("Introdu numele doctorului:");
            String nameValue = name1.nextLine();

            Scanner name2 = new Scanner(System.in);
            System.out.println("Introdu prenumele doctorului:");
            String nameValue1 = name2.nextLine();

            Scanner email1 = new Scanner(System.in);
            System.out.println("Introdu email-ul doctorului:");
            String email = email1.nextLine();

            Scanner cnp = new Scanner(System.in);
            System.out.println("Introdu CNP-ul doctorului:");
            String cnpValue = cnp.nextLine();

            Scanner experience = new Scanner(System.in);
            System.out.println("Introdu experienta doctorului(in ani):");
            int expValue = experience.nextInt();


            Scanner salary = new Scanner(System.in);
            System.out.println("Introdu salariul doctorului:");
            Double salValue = salary.nextDouble();

            Scanner phone = new Scanner(System.in);
            System.out.println("Introdu numarul de telefon al doctorului:");
            String phoneValue = phone.nextLine();


            Medici medici5 = Medici.builder()
                    .idPersoana(id_doc)
                    .nume(nameValue)
                    .prenume(nameValue1)
                    .email(email)
                    .CNP(cnpValue)
                    .adresa("Str. Margaretelor")
                    .numarTelefon(phoneValue)
                    .data_angajare("12-12-2001")
                    .experienta(expValue)
                    .salariu(salValue)
                    .programareList(List.of(new Programare(), new Programare()))
                    .build();

            mediciService.addOnlyOne(medici5);
            System.out.println(mediciService.getByNume(nameValue));

        } else if ("2".equals(Keyboard)) {

            System.out.println("Lista de doctori: ");

            var it = mediciService.getAllFromList().iterator();
            while (it.hasNext()) {
                System.out.println(it.next());
            }

            mediciService.getAllFromList()
            .forEach(elementFromList -> System.out.println(elementFromList));

        } else if ("3".equals(Keyboard)) {

            Scanner scan = new Scanner(System.in);
            System.out.print("Medic ID: ");
            String id = scan.nextLine();
            System.out.print("Modifica salariul doctorului: ");
            for(Medici med:mediciService.getAllFromList()){
                if (id.equals(med.getIdPersoana())){
                    System.out.print("Modifica salariul doctorului: ");
                    double num = scan.nextDouble();
                    med.setSalariu(num);
                    mediciService.modificaElementById(med.getIdPersoana(), med);
                    System.out.println("Dupa modificarea ");
                    mediciService.getAllFromList()
                            .forEach(elementFromList -> System.out.println(elementFromList));
                }
            }

        } else if ("4".equals(Keyboard)) {

            System.out.println("Sterge un doctor: ");
            String PersonID = keyboard.next();
            for(Medici med:mediciService.getAllFromList()){
                System.out.println(med.getIdPersoana());
                if (PersonID == med.getIdPersoana()){
                    System.out.println("id");
                    mediciService.removeElementById(PersonID);
                    mediciService.getAllFromList()
                            .forEach(elementFromList ->System.out.println(elementFromList.toString()));

                }
            }

            Scanner scan1 = new Scanner(System.in);
            System.out.print("Medic ID: ");
            String id1 = scan1.nextLine();
              System.out.print("Modifica salariul doctorului: ");

            for(Medici med:mediciService.getAllFromList()){
                if (id1.equals(med.getIdPersoana())){

                    mediciService.removeElementById(id1);
                    System.out.println("After deleting: ");
                    mediciService.getAllFromList()
                            .forEach(elementFromList -> System.out.println(elementFromList));
                }
            }

        } else if ("5".equals(Keyboard)) {
            List<Medici> DoctorList = List.of(
                    Medici.builder()
                            .idPersoana(("4"))
                            .nume("Brustur")
                            .prenume("Mihaela")
                            .email("brustur.mihaela@gmail.com")
                            .CNP("6011217932115")
                            .adresa("str. Rapsodiilor")
                            .numarTelefon("0799878954")
                            .data_angajare("1-12-2001")
                            .experienta(Integer.valueOf(5))
                            .salariu(Double.valueOf(4000))

                            .programareList(List.of(new Programare(), new Programare()))
                            .build(),

                    Medici.builder()
                            .idPersoana(("5"))
                            .nume("Grigorescu")
                            .prenume("Sorana")
                            .email("grigorescu.sorana@gmail.com")
                            .CNP("6011217875390")
                            .adresa("str. Zambilei")
                            .numarTelefon("0790979823")
                            .data_angajare("12-12-2001")
                            .experienta(Integer.valueOf(1))
                            .salariu(Double.valueOf(3000))
                            .programareList(List.of(new Programare(), new Programare()))
                            .build(),

                    Medici.builder()
                            .idPersoana(("6"))
                            .nume("Alexe")
                            .prenume("Crina")
                            .email("alexe.crina@gmail.com")
                            .CNP("6011209000635")
                            .adresa("str. Vaniliei")
                            .numarTelefon("0799090043")
                            .data_angajare("21-01-2001")
                            .experienta(Integer.valueOf(3))
                            .salariu(Double.valueOf(29000))
                            .programareList(List.of(new Programare(), new Programare()))
                            .build(),

                    Medici.builder()
                            .idPersoana("7")
                            .nume("Covrig")
                            .prenume("Matei")
                            .email("covrig.matei@gmail.com")
                            .CNP("6011217980094")
                            .adresa("str. Carpati")
                            .numarTelefon("0799874123")
                            .data_angajare("12-12-2001")
                            .experienta(Integer.valueOf(3))
                            .salariu(Double.valueOf(21000))
                            .programareList(List.of(new Programare(), new Programare()))
                            .build(),

                    Medici.builder()
                            .idPersoana(("7"))
                            .nume("Balan")
                            .prenume("Victoria")
                            .email("balan.victoria@gmail.com")
                            .CNP("6011217097895")
                            .experienta(Integer.valueOf(6))
                            .data_angajare("13-04-1995")
                            .salariu(Double.valueOf(17000))
                            .data_angajare("0790935123")
                            .programareList(List.of(new Programare(), new Programare()))
                            .build()
            );


            Optional<Object> MediciList = null;

            /*
            List<Medici> MediciList1 = MediciList.stream()
                    .sorted(Comparator.comparingDouble(value -> Medici.getSalariu(value)))
                    .collect(Collectors.toList());


            MediciList1.forEach((n) -> System.out.println(n));

             */

        } else if ("6".equals(Keyboard)) {

            List<Medicament> MedicamentList = List.of(

                    Medicament.builder()
                            .id(UUID.randomUUID())
                            .nume("Fervex")
                            .tipMedicament("Liquid")
                            .pret(Double.valueOf(45))
                            .build(),

                    Medicament.builder()
                            .id(UUID.randomUUID())
                            .nume("Forcapil")
                            .tipMedicament("Capsules")
                            .pret(Double.valueOf(80))
                            .build(),

                    Medicament.builder()
                            .id(UUID.randomUUID())
                            .nume("Nurofen")
                            .tipMedicament("Drops")
                            .pret(Double.valueOf(25))
                            .build(),

                    Medicament.builder()
                            .id(UUID.randomUUID())
                            .nume("Antinevralgic")
                            .tipMedicament("Capsules")
                            .pret(Double.valueOf(12))
                            .build(),

                    Medicament.builder()
                            .id(UUID.randomUUID())
                            .nume("Paracetamol")
                            .tipMedicament("Drops")
                            .pret(Double.valueOf(15))
                            .build()

            );

            List<Medicament> medicamentsSort = MedicamentList.stream()
                    .sorted(Comparator.comparingDouble(Medicament::getPret))
                    .collect(Collectors.toList());

            medicamentsSort.forEach((n) -> System.out.println(n));



        } else if ("7".equals(Keyboard)) {
            System.out.println("Print Excel cu lista de doctori: ");

            List<String[]> lines = new ArrayList<>();
            lines.add(new String[] {"nume", "prenume", "numar telefon", "adresa"});

            var it = mediciService.getAllFromList().iterator();
            while (it.hasNext()) {
                var doctorel = it.next();

                lines.add(new String[] {
                        doctorel.getNume(),
                        doctorel.getPrenume(),
                        doctorel.getNumarTelefon(),
                        doctorel.getEmail()
                });
            }

            /*
            Am comentat aici deoarece nu imi merge partea cu csv

            try {
                CsvWriter csvWriter = CsvWriter.getInstance();
                String lineByLineContents = csvWriter.writeLineByLine(lines, lineByLinePath);
                System.out.println("Contents of " + lineByLinePath + ":");
                System.out.println(lineByLineContents);
            } catch (Exception e) {
                e.printStackTrace();
            }
             */

        } else if ("8".equals(Keyboard)) {
            System.out.println("Introdu numele doctorului: ");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            boolean foundMedici = false;

            for (Medici med : mediciService.getAllFromList()) {
                if (nameValue.equals(med.getNume())) {

                    System.out.println("Introdu data programarii: ");
                    Scanner s = new Scanner(System.in);
                    String data = s.nextLine();
                    med.removeProgramare(data);
                    foundMedici = true;
                    break;

                }
            }

            if (!foundMedici) {
                System.out.println("Nu a fost gasit doctorul!");
            }

        }

        if ("9".equals(Keyboard)) {

            System.out.println("Introdu numele doctorului: ");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            for (int i = 0; i < mediciService.getAllFromList().size(); i++) {

                Medici med = new Medici(mediciService.getAllFromList().get(i));

                if (nameValue.equals(med.getNume())) {
                    System.out.println("Creeaza o programare\n" +
                            "Introdu data programarii: ");

                    String data = val.nextLine();

                    System.out.println("Introdu pretul programarii:  ");
                    Scanner price1 = new Scanner(System.in);
                    Double price = price1.nextDouble();

                    Programare pr = Programare.builder()
                            .idProgramare(UUID.randomUUID())
                            .data(data)
                            .pret(price)
                            .build();

                     mediciService.removeElementById(med.getIdPersoana());
                    med.addProgramare(pr);
                    mediciService.addOnlyOne(med);
                    System.out.println("Aceasta programare a fost inregistrata!");

                    break;
                }


            }

        } else if ("10".equals(Keyboard)) {

            System.out.println("Introdu data: ");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            System.out.println(programareService.getByData(nameValue));

        } else if ("11".equals(Keyboard)) {


            System.out.println("Introdu numele doctorului: ");
            Scanner val = new Scanner(System.in);
            String nameValue = val.nextLine();

            for (int i = 0; i < mediciService.getAllFromList().size(); i++) {

                Medici med = new Medici(mediciService.getAllFromList().get(i));

                if (nameValue.equals(med.getNume())) {

                    med.showProgramare();
                }

            }

        }
        else if("exit".equals(Keyboard)){
            return true;
        }

        return false;
    }
}