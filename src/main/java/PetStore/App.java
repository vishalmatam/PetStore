package PetStore;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*
## Instructions to run the application:
1. Run the application App.java - `First load the CSV, then provide search options as shown below`
2. From the command line provide the path to csv file as shown: `LOAD` `src/main/resources/pets-without-header.csv` . 
   This will print the number of pets in the CSV
3. From the command line, print the loaded CSV contents as shown: `PRINT` `1`
4. From the command line, to search for pets by location/zipcode: `LOC` `97205`
5. From the command line, to search for pets by gender: `GENDER` `male`
6. From the command line, to search for pets by type: `TYPE` `dog`
7. From the command line: `EXIT` to exit the application
*/
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
