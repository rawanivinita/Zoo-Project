package animals;

import areas.Aquarium;
import areas.Cage;
import areas.IArea;

public class AquariumAnimals extends Animal{

    //This is overridden by the animal classes of Aquarium and returns a nickname
    @Override
    public String getNickname() {
        return null;
    }

    //This is overridden by the animal classes of Aquarium
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return false;
    }

    //Checks if the given habitat is an instance of Aquarium or not
    @Override
    public boolean isCompatibleHabitat(IArea area) {
        return area instanceof Aquarium;
    }
}
