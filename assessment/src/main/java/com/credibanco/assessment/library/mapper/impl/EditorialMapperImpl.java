/*
 * Nexos Software
 */
package com.credibanco.assessment.library.mapper.impl;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.mapper.EditorialMapper;
import com.credibanco.assessment.library.model.Editorial;
import org.springframework.stereotype.Component;

/**
 *
 * @author Napoleon Avila Ochoa
 */
@Component
public class EditorialMapperImpl implements EditorialMapper {

    @Override
    public EditorialDto mapEditorialObjectToDto(Editorial obj) {
        EditorialDto dto = new EditorialDto();
        dto.setId(obj.getId());
        dto.setName(obj.getEditorialName());
        dto.setAdress(obj.getCorrespondenceAddress());
        dto.setEmail(obj.getEmail());
        dto.setPhone(obj.getPhoneNumer());
        dto.setMaximumBooks(obj.getMaximiunBooksRegistered());
        return dto;
    }

    @Override
    public Editorial mapEditorialDtoToObject(EditorialDto dto) {
        Editorial obj = new Editorial();
        obj.setId(dto.getId());
        obj.setEditorialName(dto.getName());
        obj.setCorrespondenceAddress(dto.getAdress());
        obj.setEmail(dto.getEmail());
        obj.setPhoneNumer(dto.getPhone());
        obj.setMaximiunBooksRegistered(dto.getMaximumBooks());
        return obj;
    }

}
