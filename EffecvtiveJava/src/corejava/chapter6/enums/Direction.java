package corejava.chapter6.enums;

/**
 * 
 * Defines directions based on their orientation
 *
 */
public enum Direction {

	NORTH(0), Northeast(45), EAST(90), SOUTHEAST(135), SOUTH(180), SOUTHWEST(225), WEST(270), NORTHWEST(315);

	private Direction(int orientation) {
		this.orientation = orientation;
	}

	/**
	 * 
	 * @return The opposite direction (180 degree orientation) .
	 * 
	 */
	public Direction getOpposite() {
		return valueOf((this.orientation() + 180) % 360);
	}

	/**
	 * 
	 * @return the degree of the direction.
	 * 
	 */
	public int orientation() {
		return (orientation) % 360;
	}

	/**
	 * 
	 * @param orientation
	 * @return the direction from the value of it orientation
	 * @exception IllegalArgumentException
	 *                if no Direction exist with the given orientation
	 * 
	 */
	public static Direction valueOf(int orientation) {
		for (Direction con : Direction.values())
			if (con.orientation() == orientation % 360)
				return con;
		// Unsupported direction
		throw new IllegalArgumentException();
	}

	private final int orientation;

}
