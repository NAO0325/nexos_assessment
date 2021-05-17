/*
 * Nexos Software
 */
package com.credibanco.assessment.library.mapper;

import com.credibanco.assessment.library.dto.AuthorDto;
import com.credibanco.assessment.library.model.Author;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface AuthorMapper {

    AuthorDto mapAuthorObjectToDto(Author obj);

    Author mapAuthorDtoToObject(AuthorDto dto);
}
