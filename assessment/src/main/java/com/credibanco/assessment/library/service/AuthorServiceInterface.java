/*
 * Nexos Software
 */
package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.dto.AuthorDto;
import java.util.List;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface AuthorServiceInterface {

    AuthorDto createUpdate(AuthorDto dto, StringBuilder warn) throws Exception;
    
    List<AuthorDto> listAll() throws Exception;
}
