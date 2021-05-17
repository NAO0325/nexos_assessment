/*
 * Nexos Software
 */
package com.credibanco.assessment.library.mapper.impl;

import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.mapper.BookMapper;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.model.Editorial;
import org.springframework.stereotype.Component;

/**
 *
 * @author Napoleon Avila Ochoa
 */
@Component
public class BookMapperImpl implements BookMapper {

    @Override
    public BookDto mapBookObjectToDto(Book obj) {
        BookDto dto = new BookDto();
        dto.setId(obj.getId());
        dto.setTitle(obj.getTitle());
        dto.setAuthor(obj.getAuthor().getAuthorName());
        dto.setEditorial(obj.getEditorial().getEditorialName());
        dto.setGender(obj.getGender());
        dto.setYear(obj.getYear());
        return dto;
    }

    @Override
    public Book mapBookDtoToObject(BookDto dto) {
        Book obj = new Book();

        Editorial e = new Editorial();
        e.setEditorialName(dto.getEditorial());

        Author a = new Author();
        a.setAuthorName(dto.getAuthor());

        obj.setId(dto.getId());
        obj.setTitle(dto.getTitle());
        obj.setEditorial(e);
        obj.setAuthor(a);
        obj.setGender(dto.getGender());
        obj.setYear(dto.getYear());
        return obj;
    }

}
