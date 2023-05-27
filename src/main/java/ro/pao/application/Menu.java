package ro.pao.application;

import ro.pao.model.ExampleClass;
import ro.pao.model.Medici;
import ro.pao.model.Programare;
import ro.pao.service.*;
import ro.pao.service.impl.*;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * In Meniu se fac operatiile care pot lua informatii din toate dintre servicile definite.
 * De exemplu, avem definit mai jos `private final ExampleService exampleService = new ExampleServiceImpl();`
 *
 * In cazul in care aveam definit mai multe servicii, la fel, faceam o initializare a serviciile si astfel apelam metode din serviciu.
 */



/*
public class Menu {

    private static Menu Instance;

    private final ProgramareService programareService = new ProgramareServiceImpl();

    public static Menu getInstance() {
        return (Instance == null ? new Menu() : Instance);
    }

    private final FacturaService facturaService = new FacturaServiceImpl();
    private final FisaMedicalaService fisaMedicalaService = new FisaMedicalaServiceImpl();
    private final MediciService mediciService = new MediciServiceImpl();
    private final PacientService pacientService = new PacientServiceImpl();
    private final PromotiiService promotiiService = new PromotiiServiceImpl();
    private final RezultatAnalizeService rezultatAnalizeService = new RezultatAnalizeServiceImpl();
    private final ServiciiMedicaleService serviciiMedicaleService = new ServiciiMedicaleServiceImpl();
    private final TratamentService tratamentService = new TratamentServiceImpl();

    public static void setInstance(Menu Instance) {
        Menu.Instance = Instance;
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