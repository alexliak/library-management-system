package com.library.management;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookAuthorRepository extends JpaRepository<BookAuthor, Long> {
    List<BookAuthor> findByBookId(Long bookId);
    List<BookAuthor> findByAuthorId(Long authorId);
}
