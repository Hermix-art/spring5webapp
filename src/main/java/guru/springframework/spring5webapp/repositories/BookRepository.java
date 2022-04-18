package guru.springframework.spring5webapp.repositories;

import guru.springframework.spring5webapp.model.Book;
import org.springframework.data.repository.CrudRepository;

/**
 * @author Herman Kulik
 */
public interface BookRepository extends CrudRepository<Book,Long> {// helps to save Book objects to database
}
