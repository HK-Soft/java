package corejava.chpater8;

import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import corejava.chpater5.entity.Book;
import corejava.chpater5.entity.Person;
import corejava.chpater5.repository.CrudRepository;
import corejava.chpater5.repository.ICrudRepository;

public class item23 {
	public static void main(String[] args) {

		final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();

		try {

			SessionFactory sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();

			CrudRepository<Long, Book> booksRepo = new ICrudRepository<>(sessionFactory);
			Book book = new Book("Effective Java");
			booksRepo.create(book);
			System.out.println("Your book hase been saved with id : " + book.getId());

			CrudRepository<Long, Person> personsRepo = new ICrudRepository<>(sessionFactory);
			Person person = new Person("hadj naasse", "abdeljalil");
			personsRepo.create(person);
			System.out.println("New peson hase been added with id : " + person.getId());

		} catch (Exception e) {
			// The registry would be destroyed by the SessionFactory, but we had trouble
			// building the SessionFactory
			// so destroy it manually.
			System.out.println(e.getMessage());
			StandardServiceRegistryBuilder.destroy(registry);
		}
	}
}
