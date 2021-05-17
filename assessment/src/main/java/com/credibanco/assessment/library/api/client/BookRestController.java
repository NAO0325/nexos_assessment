/*
 * Nexos Software
 */
package com.credibanco.assessment.library.api.client;

import com.credibanco.assessment.library.dto.BookDto;
import com.credibanco.assessment.library.dto.MensajeOutDto;
import com.credibanco.assessment.library.exceptions.RecordNotFoundException;
import com.credibanco.assessment.library.service.BookServiceInterface;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.ws.client.core.support.WebServiceGatewaySupport;

/**
 *
 * @author Napoleon Avila Ochoa
 */
//@CrossOrigin(origins = "http://localhost:8084")
@RestController
@RequestMapping("/api/book")
public class BookRestController extends WebServiceGatewaySupport {

    @Autowired
    BookServiceInterface service;

    @GetMapping(value = "/test")
    public ResponseEntity test() throws Exception {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body("Test Ok!");
    }

    @PostMapping(value = "/createUpdate")
    public ResponseEntity createUpdate(@RequestBody BookDto dto) throws Exception {
        StringBuilder warn = new StringBuilder();
        BookDto res = service.createUpdate(dto, warn);
        if (warn.length() > 0) {
            return ResponseEntity
                    .status(HttpStatus.BAD_REQUEST)
                    .body(new MensajeOutDto(warn.toString()));
        }
        if (res == null) {
            throw new RecordNotFoundException("No se recupero información del registro del book");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(res);
    }

    @GetMapping(value = "/allBook")
    public ResponseEntity allBook() throws Exception {
        List<BookDto> listAll = service.listAll();
        if (listAll.isEmpty()) {
            throw new RecordNotFoundException("No se encontraron registros");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listAll);
    }

    @GetMapping(value = "/allBookBySearch/{search}")
    public ResponseEntity allBookBySearch(@PathVariable("search") String search)
            throws Exception {
        List<BookDto> listAll = service.listAllBySearch(search);
        if (listAll.isEmpty()) {
            throw new RecordNotFoundException("No se encontraron registros");
        }
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(listAll);
    }
}
