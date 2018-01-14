package corejava.chpater5.repository;

import java.io.Serializable;

/**
 * 
 * @author Abdeldjalil
 *
 * @param <Key>
 *            the table key
 * @param <Value>
 *            the table value
 * 
 *            Illuminate redundancy in DB code
 * 
 */
public interface CrudRepository<Key extends Serializable, Value> {

	/**
	 * 
	 * @param value
	 *            to inserted in the database
	 * @return value as if it selected from the db by it id
	 * 
	 */
	public Value create(Value value);

	/**
	 * 
	 * @param id
	 * @return the value associated with this key
	 * 
	 */
	public Value betById(Key id);

	/**
	 * 
	 * @param id
	 * @param value
	 * 
	 */
	public void update(Key id, Value value);

	public void deleteById(Key key);
}
