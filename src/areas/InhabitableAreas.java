package areas;

public class InhabitableAreas extends Area{

    //This returns 0 because Entrance and PicnicArea can't hold any animals
    @Override
    public int getCapacity() {
        return 0;
    }

}
