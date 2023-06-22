package animals;

public class EnclosureCompatibleAnimals extends EnclosureAnimals{

    //Checks if it's not an instance of Lion because both Gazelle and Zebra are not compatible with Lion
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return !(animal instanceof Lion);
    }
}
