/*
 * Nexos Software
 */
package com.credibanco.assessment.library.mapper;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.model.Editorial;

/**
 *
 * @author Napoleon Avila Ochoa
 */

public interface EditorialMapper {

   EditorialDto mapEditorialObjectToDto(Editorial obj);
   
   Editorial mapEditorialDtoToObject(EditorialDto dto);
}
