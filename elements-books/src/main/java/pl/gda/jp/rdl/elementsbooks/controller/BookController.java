package pl.gda.jp.rdl.elementsbooks.controller;

import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import pl.gda.jp.rdl.elementsbooks.dto.BookCollectionDTO;
import pl.gda.jp.rdl.elementsbooks.dto.BookCreationDTO;
import pl.gda.jp.rdl.elementsbooks.dto.BookDTO;
import pl.gda.jp.rdl.elementsbooks.entity.Book;
import pl.gda.jp.rdl.elementsbooks.service.BookService;

@RestController
@RequestMapping("/api/books")
public class BookController {

    private final BookService bookService;

    @Autowired
    public BookController(BookService bookService) {
        this.bookService = bookService;
    }

    @PostMapping
    public ResponseEntity<BookDTO> createBook( @RequestBody BookCreationDTO bookCreationDTO) {
        try {
            BookDTO bookDto = bookService.createBook(bookCreationDTO);
            return ResponseEntity.status(201).body(bookDto);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<BookDTO> updateBook(@PathVariable UUID id, @RequestBody BookCreationDTO bookCreationDTO) {
        try {
            BookDTO bookDTO = bookService.updateBook(id, bookCreationDTO);
            return ResponseEntity.ok(bookDTO);
        } catch (IllegalArgumentException e) {
            return ResponseEntity.notFound().build();
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable UUID id) {
        if (!bookService.deleteBook(id)) return ResponseEntity.notFound().build();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDTO> getBook(@PathVariable UUID id) {
        Book book = bookService.findBookById(id);
        if (book == null) return ResponseEntity.notFound().build();
        BookDTO bookDTO = new BookDTO( book.getNazwa(), book.getRok_wydania(), book.getKsiegarnia().getNazwa());
        return ResponseEntity.ok(bookDTO);
    }
    @GetMapping
    public ResponseEntity<List<BookCollectionDTO>> getAllBooks() {
        List<BookCollectionDTO> books = bookService.findAllBooks();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/bookshop/{bookshopId}")
    public ResponseEntity<List<BookCollectionDTO>> getBooksByBookshop(@PathVariable UUID bookshopId) {
        List<BookCollectionDTO> books = bookService.findBooksByBookshop(bookshopId);
        return ResponseEntity.ok(books);
    }

}
