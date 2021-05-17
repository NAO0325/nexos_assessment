/*
 * Nexos Software
 */
package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    @Query("SELECT a FROM Author a WHERE LOWER(a.authorName) = ?1 ")
    Author findByName(String name);
}
