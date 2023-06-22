package animals;

import areas.Cage;
import areas.Enclosure;
import areas.IArea;

public class EnclosureAnimals extends Animal{

    //This is overridden by the animal classes of Enclosure and returns a nickname
    @Override
    public String getNickname() {
        return null;
    }

    //This is overridden by the animal classes of Enclosure
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return false;
    }

    //Checks if the given habitat is an instance of Enclosure or not
    @Override
    public boolean isCompatibleHabitat(IArea area) {
        return area instanceof Enclosure;
    }
}
