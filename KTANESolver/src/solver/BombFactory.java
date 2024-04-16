package solver;

import java.util.ArrayList;
import java.util.List;

public class BombFactory {
    private static List<Module> needers = new ArrayList<>();
    private static List<Module> notNeeders = new ArrayList<>();

    // Set indicators for the bomb
    public static Indicators setIndicators() {
        System.out.println("Digite o serial da bomba:");

        String serial = Main.LerEntrada();

        System.out.println("A bomba possui portas paralelas? (s/n)");
        boolean paralel = Main.LerEntrada().equals("s");

        System.out.println("A bomba possui o indicador FRK aceso? (s/n)");
        boolean FRK = Main.LerEntrada().equals("s");

        System.out.println("A bomba possui o indicador CAR aceso? (s/n)");
        boolean CAR = Main.LerEntrada().equals("s");

        System.out.println("Digite o numero de pilhas da bomba:");
        int battery = Integer.parseInt(Main.LerEntrada());

        Indicators indicators = new Indicators(serial, paralel, FRK, CAR, battery);
        return indicators;
    }

    // Detect needer modules in the bomb
    private static void detectNeeder(Module module) {
        if (module instanceof Needer) {
            needers.add(module);
        } else {
            notNeeders.add(module);
        }
    }

    // Create modules to be solved
    private static void createModules() {
        System.out.println("Digite o numero de modulos:");
        int n = Integer.parseInt(Main.LerEntrada());
        for (int i = 0; i < n; i++) {
            System.out.println("Digite o nome do modulo " + (i + 1) + ":");
            String moduleName = Main.LerEntrada();
            switch (moduleName) {
                case "button" -> detectNeeder(new Button());
                case "complicated" -> detectNeeder(new Complicated());
                case "genius" -> detectNeeder(new Genius());
                case "knobs" -> detectNeeder(new Knobs());
                case "maze" -> detectNeeder(new Maze());
                case "memory" -> detectNeeder(new Memory());
                case "morse" -> detectNeeder(new Morse());
                case "password" -> detectNeeder(new Password());
                case "sequence" -> detectNeeder(new Sequence());
                case "symbols" -> detectNeeder(new Symbols());
                case "wires" -> detectNeeder(new Wires());
                case "words" -> detectNeeder(new Words());
                default -> System.out.println(--i + ": Nome do módulo inválido. Por favor, digite novamente. ");
            }
        }
    }

    // Set modules order to be solved
    public static Module[] setModules() {
        createModules();
        int needersSpaces = (notNeeders.size() - 1) * needers.size();
        Module[] modules = new Module[notNeeders.size() + needersSpaces];
        modules[0] = notNeeders.get(0);
        notNeeders.remove(0);
        int contador = 1;
        for (Module notNeeder : notNeeders) {
            for (Module needer : needers) {
                modules[contador++] = needer;
            }
            modules[contador++] = notNeeder;
        }
        return modules;
    }
}
