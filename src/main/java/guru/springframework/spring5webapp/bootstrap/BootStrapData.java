package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.domain.Author;
import guru.springframework.spring5webapp.domain.Book;
import guru.springframework.spring5webapp.domain.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        Publisher abc=new Publisher();
        abc.setName("ABC PVT");
        abc.setAddressLine1("LA");
        abc.setState("USA");

        publisherRepository.save(abc);


        Author dhanush=new Author("dhanush","kumar");
        Book lf=new Book("loveFailure","123434");
        dhanush.getBooks().add(lf);
        lf.getAuthors().add(dhanush);
        abc.getBooks().add(lf);

        authorRepository.save(dhanush);
        bookRepository.save(lf);
        publisherRepository.save(abc);

        System.out.println("BookStored"+ authorRepository.count());
        System.out.println(abc.toString());

        authorRepository.findAll();



    }
}
