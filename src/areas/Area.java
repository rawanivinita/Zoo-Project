package areas;

import java.util.ArrayList;

public abstract class Area implements IArea{

    //An arraylist to store the adjacent areas for a new instance of this area is created
    protected ArrayList<Integer> adjacentAreas = new ArrayList<>();

    //It's overridden by each area and returns the capacity for the specific area
    public abstract int getCapacity();

    @Override
    public ArrayList<Integer> getAdjacentAreas() {
        return adjacentAreas;
    }

    @Override
    public void addAdjacentArea(int areaId) {
        adjacentAreas.add(areaId);
    }

    @Override
    public void removeAdjacentArea(int areaId) {
        adjacentAreas.remove(areaId);
    }



}
