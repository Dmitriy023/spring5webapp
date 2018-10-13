package guru.springframework.spring5webapp.bootstrap;

import guru.springframework.spring5webapp.model.Author;
import guru.springframework.spring5webapp.model.Book;
import guru.springframework.spring5webapp.model.Publisher;
import guru.springframework.spring5webapp.repositories.AuthorRepository;
import guru.springframework.spring5webapp.repositories.BookRepository;
import guru.springframework.spring5webapp.repositories.PublisherRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.http.client.MultipartBodyBuilder;
import org.springframework.stereotype.Component;

@Component
public class DevBootstrap implements ApplicationListener<ContextRefreshedEvent>{

    private AuthorRepository authorRepository;
    private BookRepository bookRepository;
    private PublisherRepository publisherRepository;

    public DevBootstrap(AuthorRepository authorRepository, BookRepository bookRepository,PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
        initData();
    }

    private void initData(){

        //ERIC
        Author eric = new Author("Eric","Evans");
        Publisher publisher = new Publisher("Eskmo","Moscow");
        Book ddd = new Book("Domain driven design", "1234",publisher);
        eric.getBooks().add(ddd);

        authorRepository.save(eric);
        publisherRepository.save(publisher);
        bookRepository.save(ddd);

        //ROD
        Author rod = new Author("Rod", "Johnson");
        Publisher publisher1 = new Publisher("Eksmo","Moscow");
        Book noEJB = new Book("J2ee Development", "23444",publisher1);
        rod.getBooks().add(noEJB);

        authorRepository.save(rod);
        publisherRepository.save(publisher1);
        bookRepository.save(noEJB);
    }
}
