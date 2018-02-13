package corejava.chapter6.enums;

import java.util.EnumSet;
import java.util.Set;

/**
 * 
 * Game default piece
 * 
 */
public class IPiece implements Piece {

	/**
	 * 
	 * Rotation angle
	 * 
	 */
	private static final int ROTATION_DEGREE = 90;

	private final int number;

	private final int positionsCount;

	private int currentPosition;

	/**
	 * 
	 * The current connection of the piece
	 * 
	 */
	private Set<Direction> face;

	private IPiece(Set<Direction> face, int number, int positionsCount) {
		this.face = face;
		this.number = number;
		this.positionsCount = positionsCount;
		this.currentPosition = 0;
	}

	public Piece createPiece(Set<Direction> face, int number, int positionsCount) {
		return new IPiece(EnumSet.copyOf(face), number, positionsCount);
	}

	public int getNumber() {
		return this.number;
	}

	public int getCurrentPosition() {
		return currentPosition;
	}

	public int getMaxPositionsCount() {
		return positionsCount;
	}

	public void turn() {
		// rotate each connection in the piece to the next angle
		Set<Direction> tempFace = EnumSet.noneOf(Direction.class);
		for (Direction connection : face)
			tempFace.add(turn(connection));
		face = tempFace;

		// calculate the next position
		currentPosition = (++currentPosition % positionsCount);
	}

	// rotate an connection using the ROTATION_DEGREE
	private Direction turn(Direction connection) {
		return Direction.valueOf((connection.orientation() * currentPosition) + ROTATION_DEGREE);
	}

	public boolean isFacing(Direction connection) {
		for (Direction con : face)
			if (con.getOpposite() == connection)
				return true;

		return false;
	}

	@Override
	public String toString() {
		return "Piece : " + getNumber() + " Position : " + getCurrentPosition() + " Face connections "
				+ getConnections();
	}

	@Override
	public Set<Direction> getConnections() {
		return face;
	}

}
