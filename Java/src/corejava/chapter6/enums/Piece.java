package corejava.chapter6.enums;

import java.util.Set;

/**
 * 
 * A game piece
 *
 */
public interface Piece {

	/**
	 * 
	 * @return the number of the piece
	 * 
	 */
	public int getNumber();

	/**
	 * 
	 * @return the maximum number of unique position
	 * 
	 */
	public int getMaxPositionsCount();

	/**
	 * 
	 * @return the current position index
	 * 
	 */
	public int getCurrentPosition();

	/**
	 * 
	 * turn once & move to the next position
	 * 
	 */
	public void turn();

	/**
	 * 
	 * @return the Set of direction faced by the piece in the current position
	 * 
	 */
	public Set<Direction> getConnections();

	/**
	 * 
	 * @param connection
	 *            Determine if this piece accept a connection from the specified
	 *            direction
	 * @return true if connection is accepted
	 * 
	 */
	public boolean isFacing(Direction connection);

}
