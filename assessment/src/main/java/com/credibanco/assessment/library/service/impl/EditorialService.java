/*
 * Nexos Software
 */
package com.credibanco.assessment.library.service.impl;

import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.mapper.impl.EditorialMapperImpl;
import com.credibanco.assessment.library.model.Editorial;
import com.credibanco.assessment.library.repository.EditorialRepository;
import com.credibanco.assessment.library.service.EditorialServiceInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Napoleon Avila Ochoa
 */
@Service
public class EditorialService implements EditorialServiceInterface {

    @Autowired
    EditorialRepository repo;

    @Autowired
    EditorialMapperImpl mapper;

    @Override
    public EditorialDto createUpdate(EditorialDto dto, StringBuilder warn)
            throws Exception {

        if (!validateFields(dto, warn)) {
            return new EditorialDto();
        }

        Editorial editorial = mapper.mapEditorialDtoToObject(dto);
        editorial.setUpdatedAt(new Date());
        if (editorial.getId() == null) {
            editorial.setCreatedAt(new Date());
        } else {
            Optional<Editorial> old = repo.findById(editorial.getId());
            editorial.setCreatedAt(old.get().getCreatedAt());
        }
        return mapper.mapEditorialObjectToDto(repo.save(editorial));
    }

    @Override
    public List<EditorialDto> listAll() throws Exception {
        List<EditorialDto> lst = new ArrayList<>();
        List<Editorial> findAll = repo.findAll();
        findAll.forEach((editorial) -> {
            lst.add(mapper.mapEditorialObjectToDto(editorial));
        });
        return lst;
    }

    @Override
    public EditorialDto finByName(String name) throws Exception {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        Editorial editorial = repo.findByName(name.toLowerCase());
        if (editorial == null || editorial.getId() == null) {
            return null;
        }
        return mapper.mapEditorialObjectToDto(editorial);
    }

    private boolean validateFields(EditorialDto dto, StringBuilder warn) {

        if (StringUtils.isBlank(dto.getName())) {
            warn.append("Debe diligenciar el campo name");
            return false;
        }

        if (StringUtils.isBlank(dto.getAdress())) {
            warn.append("Debe diligenciar el campo adress");
            return false;
        }

        if (StringUtils.isBlank(dto.getPhone())) {
            warn.append("Debe diligenciar el campo phone");
            return false;
        }

        if (dto.getMaximumBooks() == null) {
            warn.append("Debe diligenciar el campo maximumBooks");
            return false;
        }

        return true;
    }

}
