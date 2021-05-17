/*
 * Nexos Software
 */
package com.credibanco.assessment.library.service;

import com.credibanco.assessment.library.dto.EditorialDto;
import java.util.List;

/**
 *
 * @author Napoleon Avila Ochoa
 */
public interface EditorialServiceInterface {

    EditorialDto createUpdate(EditorialDto dto, StringBuilder warn) throws Exception;

    List<EditorialDto> listAll() throws Exception;
    
    EditorialDto finByName(String name) throws Exception;
}
