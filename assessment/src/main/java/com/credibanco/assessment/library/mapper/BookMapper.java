/*
 * Nexos Software
 */
package com.credibanco.assessment.library.mapper;

import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.model.Book;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface BookMapper {

    BookDto mapBookObjectToDto(Book obj);

    Book mapBookDtoToObject(BookDto dto);
}
