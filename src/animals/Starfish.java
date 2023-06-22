package animals;

import areas.Aquarium;
import areas.IArea;

public class Starfish extends AquariumAnimals{

    String nickName;

    //Initialising nickname
    public Starfish(String nickName){ this.nickName = nickName; }

    @Override
    public String getNickname() {
        return nickName;
    }

    //Always returns true because it's compatible with all animals in its habitat
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return true;
    }

}
