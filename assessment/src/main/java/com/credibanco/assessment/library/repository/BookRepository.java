/*
 * Nexos Software
 */
package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface BookRepository extends JpaRepository<Book, Long> {

}
