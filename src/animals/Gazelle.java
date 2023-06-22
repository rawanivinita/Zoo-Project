package animals;

import areas.Enclosure;
import areas.IArea;

public class Gazelle extends EnclosureCompatibleAnimals{

    String nickName;

    //Initialising nickname
    public Gazelle(String nickName){ this.nickName = nickName; }

    @Override
    public String getNickname() {
        return nickName;
    }

}
