package areas;

import java.util.ArrayList;

/**
 * This file must remain exactly as it is.
 */
public interface IArea
{

	/**
	 * @return Returns the IDs of the areas adjacent to this one.
	 */
	public ArrayList<Integer> getAdjacentAreas();
	
	/**
	 * Makes the given area adjacent to this one, so that you can move from
	 * this area to the area with the given ID. This does not automatically
	 * mean you can move the other way as well.
	 * @param areaId The ID of the area to be added.
	 */
	public void addAdjacentArea(int areaId);
	
	/**
	 * Removes the specified area from the list of areas that are adjacent
	 * to this area.
	 * @param areaId The ID of the area to be removed.
	 */
	public void removeAdjacentArea(int areaId);

}
