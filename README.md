# PetStore

## Requirements: Pet Adoption Tool
The first feature set for this tool will intake some pets, and then search for pets by location (zip code), animal type, or animal gender.

## Functionality:
1. Pet Intake: Will load a CSV file with pet information provided in the command line and store it in a HashMap
2. Search for Pets By Location (ZipCode) : Once the CSV is loaded into HashMap, based on the search criteria, prints the pet information which matches zipcode provided
3. Search for Pets By Type : Once the CSV is loaded into HashMap, based on the search criteria(type - cat, dog etc) , prints the pet information which matches type provided
4. Search for Pets By Gender : Once the CSV is loaded into HashMap, based on the search criteria(gender - male, female, spayed etc) , prints the pet information which matches gender provided

## Instructions to run the application:
1. Run the application App.java - `First load the CSV, then provide search options as shown below`
2. From the command line provide the path to csv file as shown: `LOAD` `src/main/resources/pets-without-header.csv` . This will print the number of pets in the CSV
3. From the command line, print the loaded CSV contents as shown: `PRINT` `1`
4. From the command line, to search for pets by location/zipcode: `LOC` `97205`
5. From the command line, to search for pets by gender: `GENDER` `male`
6. From the command line, to search for pets by type: `TYPE` `dog`
7. From the command line: `EXIT` to exit the application
 

## Adoption functionality: 
Given the time, I couldn't accomodate this functionality. I would approach the adoption side of operations, by extending the current functionality and have a PetAdoptionService. PetAdoptionService would have access to existing pet records and I would need to incorporate some logic to determine adoption eligibility, fee etc. 

## Testing Methodology: 
For Unit testing, I'd test layer by layer: 
For PetRepo - I'd write JUnit tests to test the save method for positive and negative scenarios
For PetService - I'd mock PetRepo using Mockito annotations and write unit tests for different search method getByLocation, getByGender etc

## Tools
Version control systems provide a centralized repository where multiple developers can work on the same/different parts of the code by creating a branch. Changes can be commited to the branch and if the tests pass then the changes can be merged to the master. Version control systems provide transparency. It's a core part of setting up a CI/CD pipeline. Can be integrated with Project Lifecycle Management tools like JIRA which again provides more visibility. Also can be integrated with code review tools like Crucible so that developers can review each other's code and suggest changes. 
Resolution of merge issues and conflicts could be cumbersome sometimes. 
