/*
 * Nexos Software
 */
package com.credibanco.assessment.library.mapper.impl;

import com.credibanco.assessment.library.dto.AuthorDto;
import com.credibanco.assessment.library.mapper.AuthorMapper;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.util.DateUtils;
import org.springframework.stereotype.Component;

/**
 *
 * @author Napoleon Avila Ochoa
 */
@Component
public class AuthorMapperImpl implements AuthorMapper {

    @Override
    public AuthorDto mapAuthorObjectToDto(Author obj) {
        AuthorDto dto = new AuthorDto();
        dto.setId(obj.getId());
        dto.setName(obj.getAuthorName());
        dto.setBirth(DateUtils.formatFechaToString(obj.getDateOfBirth(), "yyyy-MM-dd"));
        dto.setEmail(obj.getEmail());
        dto.setCity(obj.getCityOfOrigin());
        return dto;
    }

    @Override
    public Author mapAuthorDtoToObject(AuthorDto dto) {
        Author obj = new Author();
        obj.setId(dto.getId());
        obj.setAuthorName(dto.getName());
        obj.setDateOfBirth(DateUtils.getDateFromString(dto.getBirth()));
        obj.setCityOfOrigin(dto.getCity());
        obj.setEmail(dto.getEmail());
        return obj;
    }

}
