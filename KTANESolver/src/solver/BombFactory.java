package solver;

public class BombFactory {
    public static Indicators createIndicators() {
        // Set the bomb indicators
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

    // Set the bomb modules
    public static Module[] createModules() {
        System.out.println("Digite o numero de modulos:");
        int n = Integer.parseInt(Main.LerEntrada());
        Module[] modules = new Module[n];
        for (int i = 0; i < n; i++) {
            System.out.println("Digite o nome do modulo " + (i + 1) + ":");
            String moduleName = Main.LerEntrada();
            switch (moduleName) {
                case "button" -> modules[i] = new Button();
                case "complicated" -> modules[i] = new Complicated();
                case "genius" -> modules[i] = new Genius();
                case "Knobs" -> modules[i] = new Knobs();
                case "maze" -> modules[i] = new Maze();
                case "memory" -> modules[i] = new Memory();
                case "morse" -> modules[i] = new Morse();
                case "password" -> modules[i] = new Password();
                case "sequence" -> modules[i] = new Sequence();
                case "symbols" -> modules[i] = new Symbols();
                case "wires" -> modules[i] = new Wires();
                case "words" -> modules[i] = new Words();
                default -> System.out.println("Nome do módulo inválido. Por favor, digite novamente. " + i--);
            }
        }
        return modules;
    }
}
