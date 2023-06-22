package animals;

import areas.Aquarium;
import areas.IArea;

public class Seal extends AquariumAnimals{

    String nickName;

    //Initialising nickname
    public Seal(String nickName){ this.nickName = nickName;}

    @Override
    public String getNickname() { return nickName; }

    //Checks if it's not an instance of Shark
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return !(animal instanceof Shark);
    }

}
