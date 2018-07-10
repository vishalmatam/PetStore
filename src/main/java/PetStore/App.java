package PetStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class App {
    private final PetService petService = new PetService(new PetRepo());
    private static final String EXIT = "EXIT";
    private static final String LOAD = "LOAD";
    private static final String LOCATION = "LOC";
    private static final String TYPE = "TYPE";
    private static final String GENDER = "GENDER";
    private static final String PRINT = "PRINT";

    public static void main(String[] args) throws IOException {
        App app = new App();
        app.start();
    }

    private void start() throws IOException {
        System.out.println("----- PetStore App LOADED -----");

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String command = br.readLine().trim();
            if (EXIT.equalsIgnoreCase(command)) {
                break;
            }
            execute(command);
        }

        System.out.println("----- Thank you for using PetStore App  -----");
    }

    private void execute(String line) {
        String[] args = line.split(" ");
        String command = args[0].toUpperCase();
        String commandOpts = args[1];
        System.out.println("Command :" + command + " Opts: " + commandOpts);
        switch (command) {
            case LOAD: {
                getPetService().load(commandOpts);
                break;
            }
            case LOCATION: {
                getPetService().getByLocation(commandOpts);
                break;
            }
            case TYPE: {
                getPetService().getByType(commandOpts);
                break;
            }
            case GENDER: {
                getPetService().getByGender(commandOpts);
                break;
            }
            case PRINT: {
                getPetService().getAll();
                break;
            }
            default:
                System.out.println("Invalid COMMAND");
        }
    }

    public PetService getPetService() {
        return petService;
    }
}
