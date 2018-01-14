package corejava.chpater5.repository;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.NotYetImplementedException;

/**
 * HIBERNATE based implementation of the CRUD repository
 */
public class ICrudRepository<Key extends Serializable, Value> implements CrudRepository<Key, Value> {

	private static Session session;

	public ICrudRepository(SessionFactory sessionFactory) {
		try {
			session = sessionFactory.getCurrentSession();
		} catch (HibernateException e) {
			session = sessionFactory.openSession();
		}
	}

	public Value create(Value value) {
		session.save(value);
		return value;
	}

	@SuppressWarnings("unchecked")
	public Value betById(Key id) {
		assert id != null;
		return (Value) session.get(getGenericName(), id);
	}

	public void update(Key id, Value value) {
		throw new NotYetImplementedException();
	}

	public void deleteById(Key key) {
		throw new NotYetImplementedException();
	}

	@SuppressWarnings("unchecked")
	protected String getGenericName() {
		return ((Class<Value>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0])
				.getTypeName();
	}

}
