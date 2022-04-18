package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Herman Kulik
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jack = new Author("Jack", "Keruak");
        Book unnamed = new Book("hello my friend", "2123");
        jack.getBooks().add(unnamed);
        unnamed.getAuthors().add(jack);

        authorRepository.save(jack);
        bookRepository.save(unnamed);

        Author irvin = new Author("Irvine", "Welsh");
        Book train = new Book("trainspotting", "239");
        irvin.getBooks().add(train);
        train.getAuthors().add(irvin);

        authorRepository.save(irvin);
        bookRepository.save(train);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of authors: " + authorRepository.count());

        Publisher publisher = new Publisher("Sony", "USA", "New York City", "New York", "81-99872");
        publisherRepository.save(publisher);

        System.out.println("Number of publishers: " + publisherRepository.count());

    }
}
