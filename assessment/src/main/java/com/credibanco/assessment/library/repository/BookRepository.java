/*
 * Nexos Software
 */
package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Book;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT b FROM Book b WHERE b.editorial.id = ?1 ")
    List<Book> findAllByEditorialId(Long editorialId);

    @Query("SELECT b FROM Book b WHERE b.author.id = ?1 ")
    List<Book> findAllByAuthorId(Long authorId);

    @Query("SELECT b FROM Book b WHERE (LOWER(b.title) = ?1 OR LOWER(b.title) LIKE %?1%)")
    List<Book> findAllByTitle(String title);

    @Query("SELECT b FROM Book b WHERE (LOWER(b.gender) = ?1 OR LOWER(b.gender) LIKE %?1%)")
    List<Book> findAllByGender(String gender);

    @Query("SELECT b FROM Book b WHERE b.year = ?1 ")
    List<Book> findAllByYear(Integer year);

}
