/*
 * Nexos Software
 */
package com.credibanco.assessment.library.repository;

import com.credibanco.assessment.library.model.Editorial;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface EditorialRepository extends JpaRepository<Editorial, Long> {

    @Query("SELECT e FROM Editorial e WHERE LOWER(e.editorialName) = ?1 ")
    Editorial findByName(String name);

}
