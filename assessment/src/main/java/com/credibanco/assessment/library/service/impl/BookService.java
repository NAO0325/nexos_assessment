/*
 * Nexos Software
 */
package com.credibanco.assessment.library.service.impl;

import com.credibanco.assessment.library.dto.AuthorDto;
import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.dto.EditorialDto;
import com.credibanco.assessment.library.mapper.impl.AuthorMapperImpl;
import com.credibanco.assessment.library.mapper.impl.BookMapperImpl;
import com.credibanco.assessment.library.mapper.impl.EditorialMapperImpl;
import com.credibanco.assessment.library.model.Book;
import com.credibanco.assessment.library.repository.BookRepository;
import com.credibanco.assessment.library.service.AuthorServiceInterface;
import com.credibanco.assessment.library.service.BookServiceInterface;
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
public class BookService implements BookServiceInterface {

    @Autowired
    BookRepository repo;

    @Autowired
    EditorialServiceInterface editorialService;

    @Autowired
    AuthorServiceInterface authorService;

    @Autowired
    BookMapperImpl mapper;

    @Autowired
    EditorialMapperImpl editorialMapper;
    
    @Autowired
    AuthorMapperImpl authorMapper;

    @Override
    public BookDto createUpdate(BookDto dto, StringBuilder warn)
            throws Exception {

        EditorialDto e = editorialService.finByName(dto.getEditorial());
        AuthorDto a = authorService.finByName(dto.getAuthor());

        if (!validateFields(dto, e, a, warn)) {
            return new BookDto();
        }

        Book book = mapper.mapBookDtoToObject(dto);
        book.setEditorial(editorialMapper.mapEditorialDtoToObject(e));
        book.setAuthor(authorMapper.mapAuthorDtoToObject(a));
        book.setUpdatedAt(new Date());
        if (book.getId() == null) {
            book.setCreatedAt(new Date());
        } else {
            Optional<Book> old = repo.findById(book.getId());
            book.setCreatedAt(old.get().getCreatedAt());
        }
        return mapper.mapBookObjectToDto(repo.save(book));
    }

    @Override
    public List<BookDto> listAll() throws Exception {
        List<BookDto> lst = new ArrayList<>();
        List<Book> findAll = repo.findAll();
        findAll.forEach((author) -> {
            lst.add(mapper.mapBookObjectToDto(author));
        });
        return lst;
    }

    @Override
    public List<BookDto> listAllByEditorialId(Long editorialId) throws Exception {
        List<BookDto> lst = new ArrayList<>();
        if (editorialId == null) {
            return lst;
        }
        List<Book> findAll = repo.findAllByEditorialId(editorialId);
        findAll.forEach((author) -> {
            lst.add(mapper.mapBookObjectToDto(author));
        });
        return lst;
    }

    @Override
    public List<BookDto> listAllBySearch(String search) throws Exception {
        List<BookDto> lst = new ArrayList<>();
        List<Book> findAll = new ArrayList<>();

        if (StringUtils.isBlank(search)) {
            return lst;
        }

        EditorialDto e = editorialService.finByName(search);
        AuthorDto a = authorService.finByName(search);

        //Buscando por editorial
        if (e != null && e.getId() != null) {
            findAll.addAll(repo.findAllByEditorialId(e.getId()));
        }
        //Buscando por autor
        if (a != null && a.getId() != null) {
            findAll.addAll(repo.findAllByAuthorId(a.getId()));
        }
        //Buscando por año
        if (StringUtils.isNumeric(search)) {
            findAll.addAll(repo.findAllByYear(Integer.parseInt(search)));
        }
        //Buscando por título
        findAll.addAll(repo.findAllByTitle(search.toLowerCase()));
        //Buscando por genero
        findAll.addAll(repo.findAllByGender(search.toLowerCase()));

        findAll.forEach((book) -> {
            lst.add(mapper.mapBookObjectToDto(book));
        });

        return lst;
    }

    private boolean validateFields(BookDto dto, EditorialDto e, AuthorDto a,
            StringBuilder warn) throws Exception {

        if (StringUtils.isBlank(dto.getEditorial())) {
            warn.append("Debe diligenciar el campo editorial");
            return false;
        }

        if (StringUtils.isBlank(dto.getAuthor())) {
            warn.append("Debe diligenciar el campo author");
            return false;
        }

        if (StringUtils.isBlank(dto.getTitle())) {
            warn.append("Debe diligenciar el campo title");
            return false;
        }

        if (StringUtils.isBlank(dto.getGender())) {
            warn.append("Debe diligenciar el campo gender");
            return false;
        }

        if (dto.getPages() == null) {
            warn.append("Debe diligenciar el campo pages");
            return false;
        }

        if (dto.getPages() != null && dto.getPages() <= 0) {
            warn.append("El campo pages debe ser un valor mayor a cero");
            return false;
        }

        //Validaciones de editorial
        if (!validateEditorial(dto, e, warn)) {
            return false;
        }

        //Validaciones de autor
        return validateAuthor(dto, a, warn);
    }

    private boolean validateEditorial(BookDto dto, EditorialDto e,
            StringBuilder warn) throws Exception {

        if (e == null || e.getId() == null) {
            warn.append("La editorial no está registrada");
            return false;
        }

        if (dto.getId() == null) {
            List<BookDto> lst = listAllByEditorialId(e.getId());
            int newBookTotal = lst.size() + 1;

            if (e.getMaximumBooks() != -1 && e.getMaximumBooks() < newBookTotal) {
                warn.append("No es posible registrar el libro")
                        .append(", se alcanzó el máximo permitido de ")
                        .append(e.getMaximumBooks()).append(".");
                return false;
            }
        }

        return true;
    }

    private boolean validateAuthor(BookDto dto, AuthorDto a, StringBuilder warn)
            throws Exception {

        if (a == null || a.getId() == null) {
            warn.append("El author no está registrado");
            return false;
        }
        return true;
    }
}
