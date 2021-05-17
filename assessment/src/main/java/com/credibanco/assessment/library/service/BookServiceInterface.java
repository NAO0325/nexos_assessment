/*
 * Nexos Software
 */
package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.dto.BookDto;
import java.util.List;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface BookServiceInterface {

    BookDto createUpdate(BookDto dto, StringBuilder warn) throws Exception;

    List<BookDto> listAll() throws Exception;
    
    List<BookDto> listAllByEditorialId(Long editorialId) throws Exception;
    
    List<BookDto> listAllBySearch(String search) throws Exception;

}
