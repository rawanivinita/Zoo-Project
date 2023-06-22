package animals;

import areas.Enclosure;
import areas.IArea;

public class Lion extends EnclosureAnimals{

    String nickName;

    //Initialising nickname
    public Lion(String nickName){ this.nickName = nickName; }

    @Override
    public String getNickname() {
        return nickName;
    }

    //Checks if it's not an instance of Gazelle or Zebra
    @Override
    public boolean isCompatibleWith(Animal animal) {
        if (animal instanceof Gazelle || animal instanceof Zebra){
            return false;
        } else {
            return true;
        }
    }
}
