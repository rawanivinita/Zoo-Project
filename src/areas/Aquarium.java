package areas;

import java.util.ArrayList;

public class Aquarium extends Area {

     int capacity;

    //Initialises capacity
    public Aquarium(Integer capacity){ this.capacity = capacity; }

    @Override
    public int getCapacity() {
        return capacity;
    }
}
