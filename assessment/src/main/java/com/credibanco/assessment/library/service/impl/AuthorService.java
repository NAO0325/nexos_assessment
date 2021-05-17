/*
 * Nexos Software
 */
package com.credibanco.assessment.library.service.impl;

import com.credibanco.assessment.library.dto.AuthorDto;
import com.credibanco.assessment.library.mapper.impl.AuthorMapperImpl;
import com.credibanco.assessment.library.model.Author;
import com.credibanco.assessment.library.repository.AuthorRepository;
import com.credibanco.assessment.library.service.AuthorServiceInterface;
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
public class AuthorService implements AuthorServiceInterface {

    @Autowired
    AuthorRepository repo;

    @Autowired
    AuthorMapperImpl mapper;

    @Override
    public AuthorDto createUpdate(AuthorDto dto, StringBuilder warn)
            throws Exception {

        if (!validateFields(dto, warn)) {
            return new AuthorDto();
        }

        Author author = mapper.mapAuthorDtoToObject(dto);
        author.setUpdatedAt(new Date());
        if (author.getId() == null) {
            author.setCreatedAt(new Date());
        } else {
            Optional<Author> old = repo.findById(author.getId());
            author.setCreatedAt(old.get().getCreatedAt());
        }
        return mapper.mapAuthorObjectToDto(repo.save(author));
    }

    @Override
    public List<AuthorDto> listAll() throws Exception {
        List<AuthorDto> lst = new ArrayList<>();
        List<Author> findAll = repo.findAll();
        findAll.forEach((author) -> {
            lst.add(mapper.mapAuthorObjectToDto(author));
        });
        return lst;
    }

    @Override
    public AuthorDto finByName(String name) throws Exception {
        if (StringUtils.isBlank(name)) {
            return null;
        }
        Author author = repo.findByName(name.toLowerCase());
        if (author == null || author.getId() == null) {
            return null;
        }
        return mapper.mapAuthorObjectToDto(author);
    }

    private boolean validateFields(AuthorDto dto, StringBuilder warn) {

        if (StringUtils.isBlank(dto.getName())) {
            warn.append("Debe diligenciar el campo name");
            return false;
        }

        return true;
    }

}
