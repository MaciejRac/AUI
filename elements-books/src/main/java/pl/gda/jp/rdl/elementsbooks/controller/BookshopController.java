package pl.gda.jp.rdl.elementsbooks.controller;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.gda.jp.rdl.elementsbooks.dto.BookshopCreationDTO;
import pl.gda.jp.rdl.elementsbooks.dto.BookshopDTO;
import pl.gda.jp.rdl.elementsbooks.service.BookshopService;

@RestController
@RequestMapping("/api/books/bookshops")
public class BookshopController {

    private final BookshopService bookshopService;

    @Autowired
    public BookshopController(BookshopService bookshopService) {
        this.bookshopService = bookshopService;
    }

    @PostMapping
    public ResponseEntity<BookshopDTO> createBookshop(@RequestBody BookshopDTO bookshopDTO) {
        BookshopDTO bookshopDTO_final = bookshopService.createBookshop(bookshopDTO);
        return ResponseEntity.status(201).body(bookshopDTO_final);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookshopDTO> updateBookshop(@PathVariable UUID id, @RequestBody BookshopDTO bookshopDTO) {
        try {
            BookshopDTO bookshopDTO_final= bookshopService.updateBookshop(id, bookshopDTO);
            return ResponseEntity.ok(bookshopDTO_final);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookshop(@PathVariable UUID id) {
        if (!bookshopService.deleteBookshop(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }
}
