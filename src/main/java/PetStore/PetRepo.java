package PetStore;

import PetStore.model.Pet;

import java.util.*;

public class PetRepo {
    private Map<String, Pet> petStore = new HashMap<>();

    private Map<String, List<String>> locationIndex = new HashMap<>();

    private Map<String, List<String>> typeIndex = new HashMap<>();

    private Map<String, List<String>> genderIndex = new HashMap<>();

    public void save(Pet pet) {
        petStore.put(pet.getId(), pet);

        List<String> idIndex = locationIndex.getOrDefault(pet.getZipcode(), new LinkedList<>());
        idIndex.add(pet.getId());
        locationIndex.put(pet.getZipcode(), idIndex);

        idIndex = typeIndex.getOrDefault(pet.getType(), new LinkedList<>());
        idIndex.add(pet.getId());
        typeIndex.put(pet.getType(), idIndex);

        idIndex = genderIndex.getOrDefault(pet.getGender(), new LinkedList<>());
        idIndex.add(pet.getId());
        genderIndex.put(pet.getGender(), idIndex);
    }

    public Set<String> getAllIds() {
        return petStore.keySet();
    }

    public Optional<Pet> getById(String id) {
        return Optional.ofNullable(petStore.get(id));
    }

    public List<String> getByType(String type) {
        return typeIndex.get(type);
    }

    public List<String> getByLocation(String location) {
        return locationIndex.get(location);
    }

    public List<String> getByGender(String gender) {
        return genderIndex.get(gender);
    }

    public void flushDB() {
        petStore.clear();
        locationIndex.clear();
        typeIndex.clear();
        genderIndex.clear();
    }

}
