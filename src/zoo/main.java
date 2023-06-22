package zoo;

import animals.*;
import areas.*;

public class main {
    public static  void main (String[] args){
        Zoo zoo1 = new Zoo();
        Enclosure encl = new Enclosure(2);
        PicnicArea encl2 = new PicnicArea();
        PicnicArea encl3 = new PicnicArea();
        PicnicArea encl4 = new PicnicArea();
        Enclosure encl5 = new Enclosure(2);
        Enclosure encl6 = new Enclosure(2);
        //Starfish buzz = new Starfish(("buzz"));
        //zoo1.addAnimal(buzz4);
        zoo1.addArea(encl);
        zoo1.addArea(encl2);
        zoo1.addArea(encl3);
        zoo1.addArea(encl4);
        zoo1.addArea(encl5);
        zoo1.addArea(encl6);
        //zoo1.removeArea(2);
        zoo1.connectAreas(0, 6);
        zoo1.connectAreas(6, 1);
        zoo1.connectAreas(1, 4);
        zoo1.connectAreas(4, 5);
        zoo1.connectAreas(5, 3);
        //System.out.println(zoo1.findUnreachableAreas());
        zoo1.setEntranceFee(7,50);
       System.out.println(zoo1.ticketPrice);
    }
}
