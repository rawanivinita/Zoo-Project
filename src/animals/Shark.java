package animals;

import areas.Aquarium;
import areas.IArea;

public class Shark extends AquariumAnimals{

    String nickName;

    //Initialising nickname
    public Shark(String nickName){ this.nickName = nickName; }

    @Override
    public String getNickname() {
        return nickName;
    }

    //Checks if it's not an instance of Seal
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return !(animal instanceof Seal);
    }

}
