/*
 * Nexos Software
 */
package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface AuthorRepository extends JpaRepository<Author, Long> {

    
}
