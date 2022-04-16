package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * @author Herman Kulik
 */
@Component
public class BootStrapData implements CommandLineRunner {

    AuthorRepository authorRepository;
    BookRepository bookRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
    }

    @Override
    public void run(String... args) throws Exception {
        Author jack = new Author("Jack", "Keruak");
        Book unnamed = new Book("123", "hello my friend");
        jack.getBooks().add(unnamed);
        unnamed.getAuthors().add(jack);

        authorRepository.save(jack);
        bookRepository.save(unnamed);

        Author irvin = new Author("Irvine", "Welsh");
        Book train = new Book("222", "trainspotting");
        irvin.getBooks().add(train);
        train.getAuthors().add(irvin);

        System.out.println("Started in bootstrap");
        System.out.println("Number of books: " + bookRepository.count());


    }
}
