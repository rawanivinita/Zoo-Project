package animals;

import areas.Cage;
import areas.IArea;

public class Parrot extends CageAnimals{

    String nickName;

    //Initialising nickname
    public Parrot(String nickName){ this.nickName = nickName; }

    @Override
    public String getNickname() {
        return nickName;
    }

    //Checks if it's not an instance of Buzzard
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return !(animal instanceof Buzzard);
    }
}
