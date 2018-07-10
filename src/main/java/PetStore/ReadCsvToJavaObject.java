package PetStore;

import PetStore.model.Pet;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;

public class ReadCsvToJavaObject {
    private static final String COMMA_DELIMITER = ",";

    public List<Pet> loadCSVData(String path) {
       // String CSV_PATH = "src/main/resources/pets-without-header.csv";
        List<Pet> pets = null;

        try (BufferedReader br = new BufferedReader(new FileReader(path))) {
            pets = br.lines().map(this::mapLineToPet).collect(Collectors.toList());
        } catch (IOException e) {
            e.printStackTrace();
        }
        return pets;
    }

    private Pet mapLineToPet(String line) {
        String[] petsArray = line.split(COMMA_DELIMITER);
        Pet pet = new Pet();
        pet.setId(petsArray[0]);
        pet.setName(petsArray[1]);
        pet.setType(petsArray[2]);
        pet.setGender(petsArray[3]);
        pet.setZipcode(petsArray[4]);
        return pet;
    }
}
