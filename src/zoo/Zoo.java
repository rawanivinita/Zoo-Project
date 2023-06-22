package zoo;

import animals.Animal;
import areas.*;
import dataStructures.ICashCount;

import java.math.BigDecimal;
import java.util.*;

public class Zoo implements IZoo{

    //Hashmap is created to store the unique Id's and its corresponding Areas
    HashMap<Integer,Area> zooAreas = new HashMap<>();

    //Hashmap is created to store the unique Id's and arraylists of animals which corresponds to the Areas, and it's unique Id's
    HashMap<Integer, ArrayList<Animal>> animals = new HashMap<>();

    BigDecimal ticketPrice;

    //I add entrance at the start and make it unique Id 0
    public Zoo() {
            zooAreas.put(0, new Entrance());
            animals.put(0,new ArrayList<>());
        }

    //Only adds an area if it's not entrance and if it doesn't already exist
    @Override
    public int addArea(IArea area) {

        if (!(area instanceof Entrance) && !(zooAreas.containsValue(area))){
            //Adds an empty arraylist to animals so we can have an empty arraylist for each area
            animals.put(zooAreas.size(), new  ArrayList<>());
            zooAreas.put(zooAreas.size(),(Area) area);
        } else { return -1;}
        //Returns the uniqueId for this area
        return (zooAreas.size()-1);
    }

    //Removes the area if it exists and if it's not entrance
    //If it has removed the area, returns true or else false
    @Override
    public boolean removeArea(int areaId) {
        if (areaId != 0 && zooAreas.containsKey(areaId)){
            //Removes the corresponding animal arrayList
            animals.remove(areaId);
            zooAreas.remove(areaId);
            return true;
        } else {
            return false;
        }
    }

    //Gets the Area from Zoo using uniqueId
    @Override
    public IArea getArea(int areaId) {
        return zooAreas.get(areaId);
    }

    //This checks if the given animal is compatible with all the other animals already living in the given area
    public boolean checkAnimalCompatibility(int areaId, Animal animal){

        //Checks if the habitat is empty and returns true if it is
        if (animals.get(areaId).size() != 0){
            //Loops through each animal already living in the area
            for (Animal value: animals.get(areaId)){
                //Calls the isCompatiableWith function for this animal
                //Checks if this animal is compatible with each animal living in the area
                //If it's not, it returns false
                if (!(animal.isCompatibleWith(value))){
                    return false;
                }
            }
        } else {
            return true;
        }
        //By default returns true unless the conditions before return something else
        return true;
    }

    //Adds the animal if it passes all the conditions
    //Returns 0 if successful or the error code
    //The conditions have to be in that order
    @Override
    public byte addAnimal(int areaId, Animal animal) {
        Area area = zooAreas.get(areaId);

        //1st Condition: To make sure animals can't be added to Entrance or Picnic Area
        if (area instanceof PicnicArea || area instanceof Entrance){
            return Codes.NOT_A_HABITAT;
        }
        //2nd Condition: To check if the given area is suitable for this animal or not
        //Calls isCompatibleHabitat for this animal and takes the input of the Area
        else if (!animal.isCompatibleHabitat(area)){
            return Codes.WRONG_HABITAT;
        }
        //3rd Condition: To make sure we don't add animal to the given area if it's capacity is full
        //We get the total number of animals living in the given area
        //We get the capacity of the given area by calling getCapacity for it
        else if (animals.get(areaId).size() >= area.getCapacity()){ //Not correct
            return Codes.HABITAT_FULL;
        }
        //4th Condition: To make sure the animals living in the given area is compatible with the given animal
        else if (!(checkAnimalCompatibility(areaId, animal))){ //Not 100% correct
            return Codes.INCOMPATIBLE_INHABITANTS;
        } else {
            animals.get(areaId).add(animal);
            return Codes.ANIMAL_ADDED;
        }
    }

    //Makes the toAreaId adjacent to fromAreaId
    //If from and to AreaId aren't the same and if they both exist in the Hashmap
    @Override
    public void connectAreas(int fromAreaId, int toAreaId) {
        //Checks if they aren't the same and that from and to AreaId exist in the hashmap
            if (fromAreaId != toAreaId && !zooAreas.get(fromAreaId).getAdjacentAreas().contains(toAreaId)) {
                //Adds toAreaId to fromAreaId's adjacent areas arrayList
                zooAreas.get(fromAreaId).addAdjacentArea(toAreaId);
            }
    }

        //Checks it the list of areas given is a valid path or not
    //Returns true of false according to it
    @Override
    public boolean isPathAllowed(ArrayList<Integer> areaIds) {
        int areaSize = areaIds.size();

        if (areaSize == 1){
            return true;
        } else {
            //Loops through each areaId
            //In each loop, it checks is the path allowed from this area to the next area in the list
            //To check overall, if the path is allowed or not
            for (int i=0; i<areaSize-1;i++) {
                //First checks if the area exists and then gets the arraylist of adjacent areas for this areaId
                //Checks if the adjacent areas arraylist contain the next area in areaId list
                if (!(zooAreas.containsKey(areaIds.get(i)) && zooAreas.get((areaIds.get(i))).getAdjacentAreas().contains(areaIds.get(i + 1)))){
                    return false;
                }
            }
        }//By default returns true unless the conditions before return something else
            return true;
    }

    //This records the list of animals in each area in the given arrayList
    @Override
    public ArrayList<String> visit(ArrayList<Integer> areaIdsVisited) {

        //This will store all the nicknames of the animals in order
        ArrayList <String> animalNames = new ArrayList<>();

        //We first check if the path is allowed
        if (!isPathAllowed(areaIdsVisited)){
            return null;
        } else {
            //It loops for each areaId in the areaIdsVisited list
            for (Integer integer : areaIdsVisited) {
                //For each areaId, it finds the corresponding arraylist of animals
                //It loops through each animal in that area
                for (Animal name : animals.get(integer)) {
                    //It records, adds the nickname of each animal to animalNames arraylist
                    animalNames.add(name.getNickname());
                }
            }
        }
        //Returns the list of animal nicknames
        return animalNames;
    }

    @Override
    public Set<Integer> findUnreachableAreas() {
        Set <Integer> reachables = new HashSet<>();
        Set <Integer> unreachables = zooAreas.keySet();

        for (int i=1; i < zooAreas.keySet().size();i++){
            for (Integer adjId: zooAreas.keySet()){
                if (zooAreas.get(adjId).getAdjacentAreas().contains(i)){
                    reachables.add(i);
                    break;
                }
            }
        }

        unreachables.remove(0);
        unreachables.removeAll(reachables);

        return unreachables;
    }

    @Override
    public void setEntranceFee(int pounds, int pence) {
        BigDecimal pound = BigDecimal.valueOf(pounds);
        BigDecimal pences = BigDecimal.valueOf(pence);
        BigDecimal hundred = BigDecimal.valueOf(100);

        ticketPrice = pound.multiply(hundred).add(pences).divide(hundred);

    }

    @Override
    public void setCashSupply(ICashCount coins) {

    }

    @Override
    public ICashCount getCashSupply() {
        return null;
    }

    @Override
    public ICashCount payEntranceFee(ICashCount cashInserted) {
        return null;
    }
}
