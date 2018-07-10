package PetStore;

import PetStore.model.Pet;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

/*PetService - service layer to fetch pet information based on location, type, gender by calling repo methods and passing search criteria*/
public class PetService {
    private final PetRepo petRepo;
    private final ReadCsvToJavaObject readCsvToJavaObject = new ReadCsvToJavaObject();

    public PetService(PetRepo petRepo) {
        this.petRepo = petRepo;
    }

    public void load(String path) {
        List<Pet> petList = readCsvToJavaObject.loadCSVData(path);
        System.out.println("Pets Read: " + petList.size());
        petRepo.flushDB();
        petList.forEach(petRepo::save);
    }

    public void getAll(){
        print(petRepo.getAllIds());
    }

    public void getByLocation(String location) {
        print(petRepo.getByLocation(location));
    }

    public void getByType(String type) {
        print(petRepo.getByType(type));
    }

    public void getByGender(String gender) {
        print(petRepo.getByGender(gender));
    }

    private void print(Collection<String> idList) {
        if (idList != null) {
            idList.stream()
                    .map(petRepo::getById)
                    .filter(Optional::isPresent)
                    .forEach(System.out::println);
        }
    }
}
