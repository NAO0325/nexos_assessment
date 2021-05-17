/*
 * Nexos Software
 */
package com.credibanco.assessment.library.controller;

import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.service.BookServiceInterface;
import java.util.Comparator;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author Napoleon Avila Ochoa
 */
@Controller
public class BookController {

    private final BookServiceInterface bookService;
    private List<BookDto> books;

    @Autowired
    public BookController(BookServiceInterface bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public String main(Model model) throws Exception {
        books = bookService.listAll();
        model.addAttribute("books", books);
        model.addAttribute("byTitle", Comparator.comparing(BookDto::getTitle));
        return "books";
    }

    @PostMapping("/books")
    public String search(@RequestParam("search_") String search, Model model)
            throws Exception {
        if (!StringUtils.isBlank(search)) {
            books = bookService.listAllBySearch(search);
        } else {
            books = bookService.listAll();
        }
        model.addAttribute("books", books);
        model.addAttribute("byTitle", Comparator.comparing(BookDto::getTitle));
        return "books";
    }

}
