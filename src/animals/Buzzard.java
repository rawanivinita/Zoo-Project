package animals;

import areas.Cage;
import areas.IArea;

public class Buzzard extends CageAnimals{

    String nickName;

    //Initialising nickname
    public Buzzard(String nickName){ this.nickName = nickName;}

    @Override
    public String getNickname() {
        return nickName;
    }

    //Checks if it's not an instance of Parrot
    @Override
    public boolean isCompatibleWith(Animal animal) {
        return !(animal instanceof Parrot);
    }


}
