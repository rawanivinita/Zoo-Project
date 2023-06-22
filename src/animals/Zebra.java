package animals;

import areas.Enclosure;
import areas.IArea;

public class Zebra extends EnclosureCompatibleAnimals{

    String nickName;

    //Initialising nickname
    public Zebra(String nickName){ this.nickName = nickName; }

    @Override
    public String getNickname() {
        return nickName;
    }

}
