package animals;

import areas.Cage;
import areas.IArea;

public class CageAnimals extends Animal{

    //This is overridden by the animal classes of Cage and returns a nickname
    @Override
    public String getNickname() {
        return null;
    }

    //This is overridden by the animal classes of Cage
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return false;
    }

    //Checks if the given habitat is an instance of Cage or not
    @Override
    public boolean isCompatibleHabitat(IArea area) {
        return area instanceof Cage;
    }
}
