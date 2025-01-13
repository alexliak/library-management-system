package com.library.management;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import java.time.LocalDate;

public class AppRunner implements ApplicationRunner  {

    @Autowired
    BookRepository bookRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {
        // Create a sample book
        Book book = new Book();
        book.setTitle("The Clean Coder");
        book.setIsbn("9780137081073");
        book.setPublicationDate(LocalDate.of(2011, 5, 13));
        book.setGenre("Programming");
        book.setSummary("A Code of Conduct for Professional Programmers by Robert C. Martin");
        book.setCoverImageUrl("https://example.com/clean-coder.jpg");
        book.setTotalCopies(5);
        book.setAvailableCopies(5);

    }
}
