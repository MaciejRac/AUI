package pl.gda.jp.rdl.categories_bookshops.controller;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.gda.jp.rdl.categories_bookshops.dto.BookshopCollectionDTO;
import pl.gda.jp.rdl.categories_bookshops.dto.BookshopCreationDTO;
import pl.gda.jp.rdl.categories_bookshops.dto.BookshopDTO;
import pl.gda.jp.rdl.categories_bookshops.entity.Bookshop;
import pl.gda.jp.rdl.categories_bookshops.service.BookService;
import pl.gda.jp.rdl.categories_bookshops.service.BookshopService;

@RestController
@RequestMapping("/api/bookshops")
public class BookshopController {

    private final BookshopService bookshopService;
    private final BookService bookService;

    @Autowired
    public BookshopController(BookshopService bookshopService,BookService bookService) {
        this.bookshopService = bookshopService;
        this.bookService=bookService;
    }

    @PostMapping
    public ResponseEntity<BookshopDTO> createBookshop(@RequestBody BookshopCreationDTO bookshopCreationDTO) {
        BookshopDTO bookshopDTO = bookshopService.createBookshop(bookshopCreationDTO);//bookshopDTO.getId()
        bookService.addBookshop(bookshopDTO);
        return ResponseEntity.status(201).body(bookshopDTO);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookshopDTO> updateBookshop(@PathVariable UUID id, @RequestBody BookshopCreationDTO bookshopCreationDTO) {
        try {
            BookshopDTO bookshopDTO= bookshopService.updateBookshop(id, bookshopCreationDTO);
            bookService.updateBookshop(id, bookshopDTO);
            return ResponseEntity.ok(bookshopDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBookshop(@PathVariable UUID id) {
        if (!bookshopService.deleteBookshop(id)) {
            return ResponseEntity.notFound().build();
        }
        bookService.deleteBookshop(id);
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookshopDTO> getBookshop(@PathVariable UUID id) {
        Bookshop bookshop = bookshopService.findBookshopById(id);
        if (bookshop == null) return ResponseEntity.notFound().build();
        BookshopDTO bookshopDTO = new BookshopDTO(bookshop.getId(), bookshop.getNazwa(), bookshop.getLiczbaPracownikow());
        return ResponseEntity.ok(bookshopDTO);
    }

    @GetMapping
    public ResponseEntity<List<BookshopCollectionDTO>> getAllBookshops() {
        List<BookshopCollectionDTO> bookshops = bookshopService.findAllBookshops();
        return ResponseEntity.ok(bookshops);
    }
}
